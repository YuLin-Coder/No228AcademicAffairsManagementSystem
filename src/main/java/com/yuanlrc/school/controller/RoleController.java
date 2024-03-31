package com.yuanlrc.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanlrc.school.entity.Menu;
import com.yuanlrc.school.entity.Role;
import com.yuanlrc.school.entity.User;
import com.yuanlrc.school.service.MenuService;
import com.yuanlrc.school.service.RoleService;
import com.yuanlrc.school.service.UserService;
import com.yuanlrc.school.common.annotation.SysLog;
import com.yuanlrc.school.common.base.PageData;
import com.yuanlrc.school.common.util.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/system/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "list")
    public String list(){
        return "admin/role/list";
    }

    @RequiresPermissions("sys:role:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<Role> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                               ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<Role> rolePageData = new PageData<>();
        QueryWrapper<Role> roleWrapper = new QueryWrapper<>();
        roleWrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String keys = (String) map.get("key");
            if(StringUtils.isNotBlank(keys)) {
                roleWrapper.like("name", keys);
            }
        }
        IPage<Role> rolePage = roleService.page(new Page<>(page,limit),roleWrapper);
        rolePageData.setCount(rolePage.getTotal());
        rolePageData.setData(setUserToRole(rolePage.getRecords()));
        return rolePageData;
    }

    private List<Role> setUserToRole(List<Role> roles){
        roles.forEach(r -> {
            if(StringUtils.isNotBlank(r.getCreateId())){
                User u = userService.findUserById(r.getCreateId());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setCreateUser(u);
            }
            if(StringUtils.isNotBlank(r.getUpdateId())){
                User u  = userService.findUserById(r.getUpdateId());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setUpdateUser(u);
            }
        });

        return roles;
    }

    @RequestMapping("add")
    public String add(ModelMap modelMap){
        Map<String,Object> map =  new HashMap();
        map.put("parentId",null);
        map.put("isShow",false);
        List<Menu> menuList = menuService.selectAllMenus(map);
        modelMap.put("menuList",menuList);
        return "admin/role/add";
    }

    @RequiresPermissions("sys:role:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增角色数据")
    public ResponseEntity add(@RequestBody Role role){
        if(StringUtils.isBlank(role.getName())){
            return ResponseEntity.failure("角色名称不能为空");
        }
        if(roleService.getRoleNameCount(role.getName())>0){
            return ResponseEntity.failure("角色名称已存在");
        }
        roleService.saveRole(role);
        return ResponseEntity.success("操作成功");
    }

    @RequestMapping("edit")
    public String edit(String id,ModelMap modelMap){
        Role role = roleService.getRoleById(id);
        String menuIds = null;
        if(role != null) {
            menuIds  = role.getMenuSet().stream().map(menu -> menu.getId()).collect(Collectors.joining(","));
        }
        Map<String,Object> map = new HashMap();
        map.put("parentId",null);
        map.put("isShow",Boolean.FALSE);
        List<Menu> menuList = menuService.selectAllMenus(map);
        modelMap.put("role",role);
        modelMap.put("menuList",menuList);
        modelMap.put("menuIds",menuIds);
        return "admin/role/edit";
    }

    @RequiresPermissions("sys:role:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑角色数据")
    public ResponseEntity edit(@RequestBody Role role){
        if(StringUtils.isBlank(role.getId())){
            return ResponseEntity.failure("角色ID不能为空");
        }
        if(StringUtils.isBlank(role.getName())){
            return ResponseEntity.failure("角色名称不能为空");
        }
        Role oldRole = roleService.getRoleById(role.getId());
        if(!oldRole.getName().equals(role.getName())){
            if(roleService.getRoleNameCount(role.getName())>0){
                return ResponseEntity.failure("角色名称已存在");
            }
        }
        roleService.updateRole(role);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:role:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除角色数据")
    public ResponseEntity delete(@RequestParam(value = "id",required = false)String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.failure("角色ID不能为空");
        }
        Role role = roleService.getRoleById(id);
        roleService.deleteRole(role);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:role:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("多选删除角色数据")
    public ResponseEntity deleteSome(@RequestBody List<Role> roles){
        if(roles == null || roles.size()==0){
            return ResponseEntity.failure("请选择需要删除的角色");
        }
        for (Role r : roles){
            roleService.deleteRole(r);
        }
        return ResponseEntity.success("操作成功");
    }
}
