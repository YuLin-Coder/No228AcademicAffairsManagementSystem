package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.entity.pageCount;
import com.yuanlrc.school.mapper.TeacherMapper;
import com.yuanlrc.school.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    //  查询所有教师
    @Override
    public List<Map> selTeacher(TeacherDB teacherDB, pageCount pageCount) {
        int begin = pageCount.getLimit()*(pageCount.getPage()-1);
        int end = pageCount.getLimit()*pageCount.getPage()-begin;
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("tchid",teacherDB.getTchid());
        map.put("tname",teacherDB.getTname());
        return teacherMapper.selTeacher(map);
    }

    //  查询教师数量
    @Override
    public int selTeacherCount(TeacherDB teacherDB) {
        return teacherMapper.selTeacherCount(teacherDB);
    }

    //  根据教师编号查询教师信息
    @Override
    public List<TeacherDB> selTeacherId(Integer id) {
        return teacherMapper.selTeacherId(id);
    }

    //  修改教师信息
    @Override
    public int updTeacher(TeacherDB teacherDB) {
        return teacherMapper.updTeacher(teacherDB);
    }
}
