package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.TeacherDB;

import java.util.List;
import java.util.Map;

public interface GradeService {
    //  查询学生个人信息
    List<Map> selStudentMessage(String stuid);
    //  查询学生成绩信息
    List<Map> selGrade(String stuid, Integer stime);
    //  查询教师个人信息
    List<TeacherDB> selTea(Integer tid);

    //  查询学分
    Integer selCcredit(String stuid);
}
