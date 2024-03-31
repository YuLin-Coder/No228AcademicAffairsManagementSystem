package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.entity.pageCount;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    //  查询所有教师
    public List<Map> selTeacher(TeacherDB teacherDB, pageCount pageCount);
    //  查询教师数量
    public int selTeacherCount(TeacherDB teacherDB);
    //  根据教师编号查询教师信息
    public List<TeacherDB> selTeacherId(Integer id);
    //  修改教师信息
    public int updTeacher(TeacherDB teacherDB);
}
