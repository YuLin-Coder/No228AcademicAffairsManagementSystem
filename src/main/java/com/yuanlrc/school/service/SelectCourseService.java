package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.CourseTypeDB;
import com.yuanlrc.school.entity.SelectCourseVo;
import com.yuanlrc.school.entity.StuCourseDB;
import com.yuanlrc.school.entity.StudentDB;

import java.util.List;

public interface SelectCourseService {
    //查询开设课程
    public List<SelectCourseVo> sel(SelectCourseVo selectCourseVo);
    //查询课程类别
    public List<CourseTypeDB> selType();
    //查询学生id
    public StudentDB selStudentid(String stuid);
    //查询是否有该课程
    public  int selCourse(StuCourseDB stuCourseDB);
    //添加课程
    public int addCourse(StuCourseDB stuCourseDB);
    //修改可选人数
    public int updateCount(StuCourseDB stuCourseDB);
}
