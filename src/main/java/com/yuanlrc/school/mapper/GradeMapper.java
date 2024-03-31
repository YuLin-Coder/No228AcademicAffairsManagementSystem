package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.TeacherDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper {
    //  查询学生个人信息
    List<Map> selStudentMessage(String stuid);
    //  查询学生成绩信息
    List<Map> selGrade(Map<String, Object> map);
    //  查询教师个人信息
    List<TeacherDB> selTea(Integer tid);

    //  查询学分
    Integer selCcredit(String stuid);
}