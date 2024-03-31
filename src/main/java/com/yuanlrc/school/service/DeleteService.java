package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.TeacherDB;

public interface DeleteService {
    //  删除学生信息
    Integer deleteStudent(String stuid);
    //  删除学生选课信息
    Integer deleteStuCourse(String stuid);
    //  删除学生成绩表信息
    Integer deleteStuExam(String stuid);
    //  删除教评记录表信息
    Integer deleteEvaluateRecord(String stuid);
    //  班级表人数-1
    Integer deleteClassinfo(String stuid);
    //  年级人数-1
    Integer deleteGrade(String stuid);
    //  专业人数-1
    Integer deleteMajor(String stuid);
    //  系部人数-1
    Integer deleteDepartment(String stuid);

    //  修改教师为离职状态并逻辑删除
    Integer deleteTeacher(TeacherDB teacherDB);
    //  删除教师授课信息
    Integer deleteTchCourse(Integer tid);
    //  删除教师班级信息
    Integer deleteTchClass(Integer tid);
    //  删除教师成绩信息
    Integer deleteTchExam(Integer tid);
    //  删除教评记录信息
    Integer deleteTeaRecord(Integer tid);

    //  改用户登录状态改为（1）锁定状态
    Integer deleteUser(String loginName);

    //  将学生添加至dropout退学信息表
    Integer insertDropout(String stuid, String drreason);
}
