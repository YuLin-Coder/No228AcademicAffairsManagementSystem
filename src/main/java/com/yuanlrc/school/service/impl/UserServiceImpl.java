package com.yuanlrc.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanlrc.school.entity.Role;
import com.yuanlrc.school.mapper.UserMapper;
import com.yuanlrc.school.entity.User;
import com.yuanlrc.school.service.UserService;
import com.yuanlrc.school.common.util.Encodes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    
    @Override
    public User findUserByLoginName(String name) {
        Map<String,Object> map = new HashMap();
        map.put("loginName", name);
        return this.baseMapper.selectUserByMap(map);
    }

    @Override
    public User findUserById(String id) {
        Map<String,Object> map = new HashMap();
        map.put("id", id);
        return this.baseMapper.selectUserByMap(map);
    }

    @Override
    public int  userCount(String param) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name",param).or().eq("email",param).or().eq("tel",param);
        int count = this.baseMapper.selectCount(wrapper);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserRoles(String id, Set<Role> roleSet) {
        this.baseMapper.saveUserRoles(id,roleSet);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(User user) {
        Encodes.entryptPassword(user);
        user.setLocked(false);
        this.baseMapper.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
        dropUserRolesByUserId(user.getId());
        this.baseMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(User user) {
        user.setDelFlag(true);
        user.updateById();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void lockUser(User user) {
        user.setLocked(!user.getLocked());
        user.updateById();
    }

    @Transactional(rollbackFor = Exception.class)
    public void dropUserRolesByUserId(String id) {
        this.baseMapper.dropUserRolesByUserId(id);
    }


}
