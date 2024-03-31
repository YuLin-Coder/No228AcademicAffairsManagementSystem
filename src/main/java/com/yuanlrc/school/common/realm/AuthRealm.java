package com.yuanlrc.school.common.realm;

import com.yuanlrc.school.controller.LonginController;
import com.yuanlrc.school.entity.Menu;
import com.yuanlrc.school.entity.Role;
import com.yuanlrc.school.entity.User;
import com.yuanlrc.school.common.exception.UserTypeAccountException;
import com.yuanlrc.school.service.UserService;
import com.yuanlrc.school.common.util.Constants;
import com.yuanlrc.school.common.util.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component(value = "authRealm")
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser)principals.getPrimaryPrincipal();
        User user = userService.findUserByLoginName(shiroUser.getloginName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Role> roles = user.getRoleLists();
        Set<String> roleNames = new HashSet();
        for (Role role : roles) {
            if(StringUtils.isNotBlank(role.getName())){
                roleNames.add(role.getName());
            }
        }
        Set<Menu> menus = user.getMenus();
        Set<String> permissions =  new HashSet();
        for (Menu menu : menus) {
            if(StringUtils.isNotBlank(menu.getPermission())){
                permissions.add(menu.getPermission());
            }
        }
        info.setRoles(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = (String)token.getPrincipal();
        User user = userService.findUserByLoginName(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        ServletRequest request = ((WebSubject)SecurityUtils.getSubject()).getServletRequest();
        HttpSession httpSession = ((HttpServletRequest)request).getSession();
        Object attribute = httpSession.getAttribute(LonginController.LOGIN_TYPE);
        LonginController.LoginTypeEnum loginType = attribute == null ? null : (LonginController.LoginTypeEnum)attribute;
        if(LonginController.LoginTypeEnum.ADMIN.equals(loginType)) {
            if(Boolean.FALSE.equals(user.getAdminUser())) {
                throw new UserTypeAccountException(); //帐号不是后台账户
            }
        }
        byte[] salt = Encodes.decodeHex(user.getSalt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(user.getId(),user.getLoginName(),user.getNickName(), user.getIcon()),
                user.getPassword(), //密码
                ByteSource.Util.bytes(salt),
                getName()  //realm name
        );
        return authenticationInfo;
    }

    public void removeUserAuthorizationInfoCache(String username) {
        SimplePrincipalCollection pc = new SimplePrincipalCollection();
        pc.add(username, super.getName());
        super.clearCachedAuthorizationInfo(pc);
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Constants.HASH_ALGORITHM);
        matcher.setHashIterations(Constants.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

    /**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable {

        private static final long serialVersionUID = -1373760761780840081L;

        public String id;
        public String loginName;
        public String nickName;
        public String icon;

        public ShiroUser(String id, String loginName, String nickName,String icon) {
            this.id = id;
            this.loginName = loginName;
            this.nickName = nickName;
            this.icon=icon;
        }

        public String getloginName() {
            return loginName;
        }
        public String getNickName() {
            return nickName;
        }
        public String getIcon() {
            return icon;
        }
        public String getId() {
            return id;
        }



        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return nickName;
        }

        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(loginName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (loginName == null) {
                return other.loginName == null;
            } else return loginName.equals(other.loginName);
        }
    }
}
