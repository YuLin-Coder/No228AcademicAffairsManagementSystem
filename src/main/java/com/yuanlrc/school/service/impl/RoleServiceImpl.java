package com.yuanlrc.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanlrc.school.entity.Role;
import com.yuanlrc.school.mapper.RoleMapper;
import com.yuanlrc.school.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Override
    public long getRoleNameCount(String name) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role saveRole(Role role) {
        baseMapper.insert(role);
        if(role.getMenuSet() != null && role.getMenuSet().size() > 0) {
            baseMapper.saveRoleMenus(role.getId(),role.getMenuSet());
        }
        return role;
    }

    @Override
    public Role getRoleById(String id) {
        return baseMapper.selectRoleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(Role role) {
        baseMapper.updateById(role);
        baseMapper.dropRoleMenus(role.getId());
        if(role.getMenuSet() != null && role.getMenuSet().size() > 0) {
            baseMapper.saveRoleMenus(role.getId(), role.getMenuSet());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(Role role) {
        role.setDelFlag(true);
        baseMapper.updateById(role);
        baseMapper.dropRoleMenus(role.getId());
        baseMapper.dropRoleUsers(role.getId());
    }

    @Override
    public List<Role> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("del_flag",false);
        return baseMapper.selectList(wrapper);
    }
}
