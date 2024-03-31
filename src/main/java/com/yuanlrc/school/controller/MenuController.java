package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.Menu;
import com.yuanlrc.school.service.MenuService;
import com.yuanlrc.school.common.annotation.SysLog;
import com.yuanlrc.school.common.util.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("admin/system/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("list")
    @SysLog("跳转菜单列表")
    public String list(){
        return "admin/menu/list";
    }

    @RequiresPermissions("sys:menu:list")
    @RequestMapping("treeList")
    @ResponseBody
    public ResponseEntity treeList(){
        ResponseEntity responseEntity = ResponseEntity.success("操作成功");
        responseEntity.setAny("code",0);
        responseEntity.setAny("msg","");
        responseEntity.setAny("count","");
        HashMap map = new HashMap();
        map.put("del_flag",false);
        List<Menu> menus = menuService.selectAllMenuList(map);
        menus.forEach( menu -> {
            if(StringUtils.isBlank(menu.getParentId())) {
                menu.setParentId("-1");
            }
        });
        menus.sort(Comparator.comparing(Menu::getSort));
        return responseEntity.setAny("data",menus);
    }

    @RequestMapping("add")
    public String add(@RequestParam(value = "parentId",required = false) String parentId, ModelMap modelMap){
        if(parentId != null){
            Menu menu = menuService.selectById(parentId);
            modelMap.put("parentMenu",menu);
        }
        return "admin/menu/add";
    }

    @RequiresPermissions("sys:menu:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增菜单数据")
    public ResponseEntity add(Menu menu){
        if(StringUtils.isBlank(menu.getName())){
            return ResponseEntity.failure("菜单名称不能为空");
        }
        if(menuService.getCountByName(menu.getName())>0){
            return ResponseEntity.failure("菜单名称已存在");
        }
        if(StringUtils.isNotBlank(menu.getPermission())){
            if(menuService.getCountByPermission(menu.getPermission())>0){
                return ResponseEntity.failure("权限标识已经存在");
            }
        }
        if(menu.getParentId() == null){
            menu.setLevel(1);
            menu.setSort(menuService.selectFirstLevelMenuMaxSort());
        }else{
            Menu parentMenu = menuService.selectById(menu.getParentId());
            if(parentMenu==null){
                return ResponseEntity.failure("父菜单不存在");
            }
            menu.setParentIds(parentMenu.getParentIds());
            menu.setLevel(parentMenu.getLevel()+1);
            menu.setSort(menuService.seleclMenuMaxSortByPArentId(menu.getParentId()));
        }
        menuService.saveOrUpdateMenu(menu);
        menu.setParentIds(StringUtils.isBlank(menu.getParentIds()) ? menu.getId()+"," : menu.getParentIds() + menu.getId()+",");
        menuService.saveOrUpdateMenu(menu);
        return ResponseEntity.success("操作成功");
    }

    @RequestMapping("edit")
    public String edit(String id,ModelMap modelMap){
        Menu menu = menuService.selectById(id);
        modelMap.addAttribute("menu",menu);
        return "admin/menu/edit";
    }

    @RequiresPermissions("sys:menu:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑菜单数据")
    public ResponseEntity edit(Menu menu){
        if(StringUtils.isBlank(menu.getId())){
            return ResponseEntity.failure("菜单ID不能为空");
        }
        if (StringUtils.isBlank(menu.getName())) {
            return ResponseEntity.failure("菜单名称不能为空");
        }
        Menu oldMenu = menuService.selectById(menu.getId());
        if(!oldMenu.getName().equals(menu.getName())) {
            if(menuService.getCountByName(menu.getName())>0){
                return ResponseEntity.failure("菜单名称已存在");
            }
        }
        if (StringUtils.isNotBlank(menu.getPermission())) {
            if(!oldMenu.getPermission().equals(menu.getPermission())) {
                if (menuService.getCountByPermission(menu.getPermission()) > 0) {
                    return ResponseEntity.failure("权限标识已经存在");
                }
            }
        }
        if(menu.getSort() == null){
            return ResponseEntity.failure("排序值不能为空");
        }
        menuService.saveOrUpdateMenu(menu);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:menu:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除菜单")
    public ResponseEntity delete(@RequestParam(value = "id",required = false)String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.failure("菜单ID不能为空");
        }
        Menu menu = menuService.selectById(id);
        menu.setDelFlag(true);
        menuService.saveOrUpdateMenu(menu);
        return ResponseEntity.success("操作成功");
    }

}
