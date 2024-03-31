package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.mapper.AddTEacherMapper;
import com.yuanlrc.school.service.AddTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AddTeacherServiceImpl implements AddTeacherService {
    @Resource
    private AddTEacherMapper addTEacherMapper;


    //  添加教师
    @Override
    public Integer addTeacher(TeacherDB teacherDB) {
        return addTEacherMapper.addTeacher(teacherDB);
    }
    //  判断是否要插入新一年分割工号 1要插入，0不用插入
    @Override
    public Integer selectYear() {
        return addTEacherMapper.selectYear();
    }

    //  添加一条分割线
    @Override
    public Integer teaSegmentation() {
        return addTEacherMapper.teaSegmentation();
    }

    //  生成教师工号
    @Override
    public String selTchid() {
        return addTEacherMapper.selTchid();
    }

    //  根据教师工号查询信息
    @Override
    public List<TeacherDB> selTeaMessage(String tchid) {
        return addTEacherMapper.selTeaMessage(tchid);
    }

    //  查询sys_role角色id
    @Override
    public String selectTeaRole() {
        return addTEacherMapper.selectTeaRole();
    }

    //  查询教师数量
    @Override
    public Integer selTeacherCount() {
        return addTEacherMapper.selTeacherCount();
    }
}
