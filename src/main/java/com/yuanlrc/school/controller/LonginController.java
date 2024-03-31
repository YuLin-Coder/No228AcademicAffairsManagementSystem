package com.yuanlrc.school.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yuanlrc.school.entity.ShowMenuVo;
import com.yuanlrc.school.service.MenuService;
import com.yuanlrc.school.service.UserService;
import com.yuanlrc.school.common.annotation.SysLog;
import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.common.exception.UserTypeAccountException;
import com.yuanlrc.school.common.realm.AuthRealm;
import com.yuanlrc.school.common.util.Constants;
import com.yuanlrc.school.common.util.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

@Controller
public class LonginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LonginController.class);

    public final static String LOGIN_TYPE = "loginType";

    @Autowired
    @Qualifier("captchaProducer")
    DefaultKaptcha captchaProducer;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    public enum LoginTypeEnum {
        PAGE,ADMIN;
    }

//    @RequestMapping(value = "")
//    public String welcome() {
//        return "redirect:admin";
//    }

    @RequestMapping(value = {"admin","admin/index"})
    public String adminIndex(RedirectAttributes attributes, ModelMap map) {
        Subject s = SecurityUtils.getSubject();
        attributes.addFlashAttribute(LOGIN_TYPE, LoginTypeEnum.ADMIN);
        if(s.isAuthenticated()) {
            return "redirect:index";
        }
        return "redirect:toLogin";
    }

    @RequestMapping(value = "toLogin")
    public String adminToLogin(HttpSession session, @ModelAttribute(LOGIN_TYPE) String loginType) {
        if(StringUtils.isBlank(loginType)) {
            LoginTypeEnum attribute = (LoginTypeEnum) session.getAttribute(LOGIN_TYPE);
            loginType = attribute == null ? loginType : attribute.name();
        }

        if(LoginTypeEnum.ADMIN.name().equals(loginType)) {
            session.setAttribute(LOGIN_TYPE,LoginTypeEnum.ADMIN);
            return "admin/login";
        }else {
            session.setAttribute(LOGIN_TYPE,LoginTypeEnum.PAGE);
            return "login";
        }
    }

    @RequestMapping(value = "index")
    public String index(HttpSession session, @ModelAttribute(LOGIN_TYPE) String loginType) {
        if(StringUtils.isBlank(loginType)) {
            LoginTypeEnum attribute = (LoginTypeEnum) session.getAttribute(LOGIN_TYPE);
            loginType = attribute == null ? loginType : attribute.name();
        }
        if(LoginTypeEnum.ADMIN.name().equals(loginType)) {
            AuthRealm.ShiroUser principal = (AuthRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
            session.setAttribute("icon",StringUtils.isBlank(principal.getIcon()) ? "/static/admin/img/face.jpg" : principal.getIcon());
            return "admin/index";
        }else {
            AuthRealm.ShiroUser principal = (AuthRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();

            return "admin/index";
        }

    }

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = captchaProducer.createText();
        //将验证码放到HttpSession里面
        request.getSession().setAttribute(Constants.VALIDATE_CODE, verifyCode);
        LOGGER.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = captchaProducer.createImage(verifyCode);
        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    @PostMapping("admin/login")
    @SysLog("用户登录")
    @ResponseBody
    public ResponseEntity adminLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        String code = request.getParameter("code");
        String driver = request.getParameter("driver");
        String errorMsg = null;
        //判断登陆设备
        if(StringUtils.isBlank(driver)){
            //电脑登录
            if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
                return ResponseEntity.failure("用户名或者密码不能为空");
            }else if(StringUtils.isBlank(code)){
                return ResponseEntity.failure("验证码不能为空");
            }
            HttpSession session = request.getSession();
            if(session == null){
                return ResponseEntity.failure("session超时");
            }
            String trueCode = (String)session.getAttribute(Constants.VALIDATE_CODE);
            if(StringUtils.isBlank(trueCode)){
                return ResponseEntity.failure("验证码超时");
            }
            if(StringUtils.isBlank(code) || !trueCode.toLowerCase().equals(code.toLowerCase())){
                return ResponseEntity.failure("验证码错误");
            }else {
                Subject user = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username,password,Boolean.valueOf(rememberMe));
                try {
                    user.login(token);
                }catch (IncorrectCredentialsException e) {
                    errorMsg = "用户名密码错误!";
                }catch (UnknownAccountException e) {
                    errorMsg = "账户不存在!";
                }catch (LockedAccountException e) {
                    errorMsg = "账户已被锁定!";
                }catch (UserTypeAccountException e) {
                    errorMsg = "账户不是管理用户!";
                }
                if(StringUtils.isBlank(errorMsg)) {
                    ResponseEntity responseEntity = new ResponseEntity();
                    responseEntity.setSuccess(Boolean.TRUE);
                    responseEntity.setAny("url","index");
                    return responseEntity;
                }else {
                    return ResponseEntity.failure(errorMsg);
                }
            }
        }else{
            //小程序或APP登录
            if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
                return ResponseEntity.failure("用户名或者密码不能为空");
            }
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password,Boolean.valueOf(rememberMe));
            try {
                user.login(token);
            }catch (IncorrectCredentialsException e) {
                errorMsg = "用户名或密码错误!";
            }catch (UnknownAccountException e) {
                errorMsg = "账户不存在!";
            }catch (LockedAccountException e) {
                errorMsg = "账户已被锁定!";
            }catch (UserTypeAccountException e) {
                errorMsg = "账户不是管理用户!";
            }
            if(StringUtils.isBlank(errorMsg)) {
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setSuccess(Boolean.TRUE);
                responseEntity.setAny("url","index");
                return responseEntity;
            }else {
                return ResponseEntity.failure(errorMsg);
            }
        }





    }

    @RequestMapping("admin/main")
    public String main(ModelMap map){
        return "admin/main";
    }

    /***
     * 获得用户所拥有的菜单列表
     * @return
     */
    @RequestMapping("/admin/user/getUserMenu")
    @ResponseBody
    public List<ShowMenuVo> getUserMenu(){
        String userId = MySysUser.id();
        List<ShowMenuVo> list = menuService.getShowMenuByUser(userId);
        return list;
    }

    @RequestMapping("systemLogout")
    @SysLog("退出系统")
    public String logOut(){
        SecurityUtils.getSubject().logout();
        return "redirect:home";
    }

}
