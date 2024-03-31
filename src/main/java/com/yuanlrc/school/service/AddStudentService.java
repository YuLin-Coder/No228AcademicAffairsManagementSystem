package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.CourseDB;
import com.yuanlrc.school.entity.StudentDB;
import com.yuanlrc.school.entity.StudentVO;

import java.util.List;

public interface AddStudentService {
    //  根据前台传来信息添加学生
    Integer addStudent(StudentVO studentVO);
    //  根据学生专业查询该专业开设的必修课程
    List<CourseDB> selCourse(Integer mid);
    //  根据学号查询学生id编号
    Integer selectSid(String stuid);
    //  将学生id以及必修课程的id添加至学生选课表
    Integer addStuCourse(Integer sid, Integer cid);
    //  生成学生学号
    String selStuid(Integer gid);

    //  班级人数+1
    Integer selecteClassinfo(Integer classid);
    //  年级人数+1
    Integer selecteGrade(Integer gid);
    //  专业人数+1
    Integer selecteMajor(Integer mid);
    //  系部人数+1
    Integer selecteDepartment(Integer did);

    //  判断该年份是否已存在学生
    Integer selectStuYear(Integer classid);
    //  若该年份学生为空时 则添加一条分割线
    Integer stuSegmentation(Integer classid);

    //  根据学号查询信息
    List<StudentDB> selectMessage(String stuid);
    //  查询sys_role角色id
    String selectRole();
}
