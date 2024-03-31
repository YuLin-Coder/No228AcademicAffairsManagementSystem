package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.mapper.DeleteMapper;
import com.yuanlrc.school.service.DeleteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DeleteServiceImpl implements DeleteService {
    @Resource
    private DeleteMapper deleteMapper;

    //  删除学生信息
    @Override
    public Integer deleteStudent(String stuid) {
        return deleteMapper.deleteStudent(stuid);
    }

    //  删除学生选课信息
    @Override
    public Integer deleteStuCourse(String stuid) {
        return deleteMapper.deleteStuCourse(stuid);
    }

    //  删除学生成绩表信息
    @Override
    public Integer deleteStuExam(String stuid) {
        return deleteMapper.deleteStuExam(stuid);
    }

    //  删除教评记录表信息
    @Override
    public Integer deleteEvaluateRecord(String stuid) {
        return deleteMapper.deleteEvaluateRecord(stuid);
    }

    //  班级表人数-1
    @Override
    public Integer deleteClassinfo(String stuid) {
        return deleteMapper.deleteClassinfo(stuid);
    }

    //  年级人数-1
    @Override
    public Integer deleteGrade(String stuid) {
        return deleteMapper.deleteGrade(stuid);
    }

    //  专业人数-1
    @Override
    public Integer deleteMajor(String stuid) {
        return deleteMapper.deleteMajor(stuid);
    }

    //  系部人数-1
    @Override
    public Integer deleteDepartment(String stuid) {
        return deleteMapper.deleteDepartment(stuid);
    }


    //  修改教师为离职状态并逻辑删除
    @Override
    public Integer deleteTeacher(TeacherDB teacherDB) {
        return deleteMapper.deleteTeacher(teacherDB);
    }

    //  删除教师授课信息
    @Override
    public Integer deleteTchCourse(Integer tid) {
        return deleteMapper.deleteTchCourse(tid);
    }

    //  删除教师班级信息
    @Override
    public Integer deleteTchClass(Integer tid) {
        return deleteMapper.deleteTchClass(tid);
    }

    //  删除教师成绩信息
    @Override
    public Integer deleteTchExam(Integer tid) {
        return deleteMapper.deleteTchExam(tid);
    }

    //  删除教评记录信息
    @Override
    public Integer deleteTeaRecord(Integer tid) {
        return deleteMapper.deleteTeaRecord(tid);
    }

    //  改用户登录状态改为（1）锁定状态
    @Override
    public Integer deleteUser(String loginName) {
        return deleteMapper.deleteUser(loginName);
    }


    //  将学生添加至dropout退学信息表
    @Override
    public Integer insertDropout(String stuid, String drreason) {
        return deleteMapper.insertDropout(stuid,drreason);
    }
}
