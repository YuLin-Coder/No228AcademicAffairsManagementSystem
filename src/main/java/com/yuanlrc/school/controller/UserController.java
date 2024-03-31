package com.yuanlrc.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanlrc.school.entity.Role;
import com.yuanlrc.school.entity.User;
import com.yuanlrc.school.service.RoleService;
import com.yuanlrc.school.service.UploadService;
import com.yuanlrc.school.service.UserService;
import com.yuanlrc.school.common.annotation.SysLog;
import com.yuanlrc.school.common.base.PageData;
import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.common.util.Constants;
import com.yuanlrc.school.common.util.Encodes;
import com.yuanlrc.school.common.util.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/system/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UploadService uploadService;

    @RequestMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list(){
        return "admin/user/list";
    }

    @RequiresPermissions("sys:user:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<User> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                               ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<User> userPageData = new PageData<>();
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        if(!map.isEmpty()){
            String type = (String) map.get("type");
            if(StringUtils.isNotBlank(type)) {
                userWrapper.eq("is_admin", "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if(StringUtils.isNotBlank(keys)) {
                userWrapper.and(wrapper -> wrapper.like("login_name", keys).or().like("tel", keys).or().like("email", keys));
            }
        }
        IPage<User> userPage = userService.page(new Page<>(page,limit),userWrapper);
        userPageData.setCount(userPage.getTotal());
        userPageData.setData(userPage.getRecords());
        return userPageData;
    }

    @RequestMapping("add")
    public String add(ModelMap modelMap){
        List<Role> roleList = roleService.selectAll();
        modelMap.put("roleList",roleList);
        return "admin/user/add";
    }

    @RequiresPermissions("sys:user:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增系统用户数据")
    public ResponseEntity add(@RequestBody  User user){
        if(StringUtils.isBlank(user.getLoginName())){
            return ResponseEntity.failure("登录名不能为空");
        }
        if(user.getRoleLists() == null || user.getRoleLists().size() == 0){
            return  ResponseEntity.failure("用户角色至少选择一个");
        }
        if(userService.userCount(user.getLoginName())>0){
            return ResponseEntity.failure("登录名称已经存在");
        }
//        if(StringUtils.isNotBlank(user.getEmail())){
//            if(userService.userCount(user.getEmail())>0){
//                return ResponseEntity.failure("该邮箱已被使用");
//            }
//        }
//        if(StringUtils.isNoneBlank(user.getTel())){
//            if(userService.userCount(user.getTel())>0){
//                return ResponseEntity.failure("该手机号已被绑定");
//            }
//        }
        //设置默认密码
        if(StringUtils.isBlank(user.getPassword())){
            user.setPassword(Constants.DEFAULT_PASSWORD);
        }
        userService.saveUser(user);
        if(StringUtils.isBlank(user.getId())){
            return ResponseEntity.failure("保存用户信息出错");
        }
        //保存用户角色关系
        userService.saveUserRoles(user.getId(),user.getRoleLists());
        return ResponseEntity.success("操作成功");
    }

    @RequestMapping("edit")
    public String edit(String id,ModelMap modelMap){
        User user = userService.findUserById(id);
        String roleIds = "";
        if(user != null) {
            roleIds = user.getRoleLists().stream().map(role -> role.getId()).collect(Collectors.joining(","));
        }
        List<Role> roleList = roleService.selectAll();
        modelMap.put("localuser",user);
        modelMap.put("roleIds",roleIds);
        modelMap.put("roleList",roleList);
        return "admin/user/edit";
    }

    @RequiresPermissions("sys:user:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存系统用户编辑数据")
    public ResponseEntity edit(@RequestBody  User user){
        if(StringUtils.isBlank(user.getId())){
            return ResponseEntity.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(user.getLoginName())){
            return ResponseEntity.failure("登录名不能为空");
        }
        if(user.getRoleLists() == null || user.getRoleLists().size() == 0){
            return  ResponseEntity.failure("用户角色至少选择一个");
        }
        User oldUser = userService.findUserById(user.getId());
        if(StringUtils.isNotBlank(user.getEmail())){
            if(!user.getEmail().equals(oldUser.getEmail())){
                if(userService.userCount(user.getEmail())>0){
                    return ResponseEntity.failure("该邮箱已被使用");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getLoginName())){
            if(!user.getLoginName().equals(oldUser.getLoginName())) {
                if (userService.userCount(user.getLoginName()) > 0) {
                    return ResponseEntity.failure("该登录名已存在");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getTel())){
            if(!user.getTel().equals(oldUser.getTel())) {
                if (userService.userCount(user.getTel()) > 0) {
                    return ResponseEntity.failure("该手机号已经被绑定");
                }
            }
        }
        user.setIcon(oldUser.getIcon());
        userService.updateUser(user);

        if(StringUtils.isBlank(user.getId())){
            return ResponseEntity.failure("保存用户信息出错");
        }
        userService.saveUserRoles(user.getId(),user.getRoleLists());
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:user:lock")
    @PostMapping("lock")
    @ResponseBody
    @SysLog("锁定或开启系统用户")
    public ResponseEntity lock(@RequestParam(value = "id",required = false)String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.failure("参数错误");
        }
        User user = userService.getById(id);
        if(user == null){
            return ResponseEntity.failure("用户不存在");
        }
        userService.lockUser(user);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:user:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除系统用户数据(单个)")
    public ResponseEntity delete(@RequestParam(value = "id",required = false)String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.failure("参数错误");
        }
        User user = userService.getById(id);
        if(user == null){
            return ResponseEntity.failure("用户不存在");
        }else if(user.getAdminUser()) {
            return ResponseEntity.failure("不能删除后台用户");
        }
        userService.deleteUser(user);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:user:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除系统用户数据(多个)")
    public ResponseEntity deleteSome(@RequestBody List<User> users){
        if(users == null || users.size()==0){
            return ResponseEntity.failure("请选择需要删除的用户");
        }
        for (User u : users){
            if(u.getAdminUser()){
                return ResponseEntity.failure("不能删除超级管理员");
            }else{
                userService.deleteUser(u);
            }
        }
        return ResponseEntity.success("操作成功");
    }

    @RequestMapping("userinfo")
    public String toEditMyInfo(ModelMap modelMap){
        String userId = MySysUser.id();
        User user = userService.findUserById(userId);
        modelMap.put("userinfo",user);
        modelMap.put("userRole",user.getRoleLists());
        return "admin/user/userInfo";
    }

    @SysLog("系统用户个人信息修改")
    @PostMapping("saveUserinfo")
    @ResponseBody
    public ResponseEntity saveUserInfo(User user){
        if(StringUtils.isBlank(user.getId())){
            return ResponseEntity.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(user.getLoginName())){
            return ResponseEntity.failure("登录名不能为空");
        }
        User oldUser = userService.findUserById(user.getId());
        if(StringUtils.isNotBlank(user.getEmail())){
            if(!user.getEmail().equals(oldUser.getEmail())){
                if(userService.userCount(user.getEmail())>0){
                    return ResponseEntity.failure("该邮箱已被使用");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getTel())){
            if(!user.getTel().equals(oldUser.getTel())) {
                if (userService.userCount(user.getTel()) > 0) {
                    return ResponseEntity.failure("该手机号已经被绑定");
                }
            }
        }
        userService.updateById(user);
        return ResponseEntity.success("操作成功");
    }

    @RequestMapping("changePassword")
    public String changePassword(ModelMap modelMap){
        modelMap.put("currentUser",userService.getById(MySysUser.id()));
        return "admin/user/changePassword";
    }
    @CrossOrigin
    @SysLog("用户修改密码")
    @PostMapping("changePassword")
    @ResponseBody
    public ResponseEntity changePassword(@RequestParam(value = "userName",required = false)String userName,
                                         @RequestParam(value = "oldPwd",required = false)String oldPwd,
                                       @RequestParam(value = "newPwd",required = false)String newPwd,
                                       @RequestParam(value = "confirmPwd",required = false)String confirmPwd){
        if(StringUtils.isBlank(oldPwd)){
            return ResponseEntity.failure("旧密码不能为空");
        }
        if(StringUtils.isBlank(newPwd)){
            return ResponseEntity.failure("新密码不能为空");
        }
        if(StringUtils.isBlank(confirmPwd)){
            return ResponseEntity.failure("确认密码不能为空");
        }
        if(!confirmPwd.equals(newPwd)){
            return ResponseEntity.failure("确认密码与新密码不一致");
        }
        //小程序修改密码
        if(StringUtils.isBlank(userName)){
            //PC修改密码
            User user = userService.findUserById(MySysUser.id());

            byte[] hashPassword = Encodes.sha1(oldPwd.getBytes(), Encodes.SHA1, Encodes.decodeHex(user.getSalt()), Constants.HASH_INTERATIONS);
            String password = Encodes.encodeHex(hashPassword);

            if(!user.getPassword().equals(password)){
                return ResponseEntity.failure("旧密码错误");
            }
            user.setPassword(newPwd);
            Encodes.entryptPassword(user);
            userService.updateById(user);
            return ResponseEntity.success("操作成功");
        }else {
            //小程序修改密码
            User user = userService.findUserByLoginName(userName);

            byte[] hashPassword = Encodes.sha1(oldPwd.getBytes(), Encodes.SHA1, Encodes.decodeHex(user.getSalt()), Constants.HASH_INTERATIONS);
            String password = Encodes.encodeHex(hashPassword);

            if(!user.getPassword().equals(password)){
                return ResponseEntity.failure("旧密码错误");
            }
            user.setPassword(newPwd);
            Encodes.entryptPassword(user);
            userService.updateById(user);
            return ResponseEntity.success("操作成功");
        }

    }

    @SysLog("上传头像")
    @PostMapping("uploadFace")
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam("icon") MultipartFile file, HttpServletRequest httpServletRequest) {
        if(file == null){
            return ResponseEntity.failure("上传文件为空 ");
        }
        String url = null;
        Map map = new HashMap();
        try {
            url = uploadService.upload(file);
            map.put("url", url);
            map.put("name", file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.failure(e.getMessage());
        }
        return ResponseEntity.success("操作成功").setAny("data",map);
    }

}
