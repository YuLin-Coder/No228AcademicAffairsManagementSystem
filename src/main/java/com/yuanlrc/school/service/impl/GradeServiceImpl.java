package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.mapper.GradeMapper;
import com.yuanlrc.school.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeMapper gradeMapper;

    //  查询学生个人信息
    @Override
    public List<Map> selStudentMessage(String stuid) {
        return gradeMapper.selStudentMessage(stuid);
    }

    //  查询学生成绩信息
    @Override
    public List<Map> selGrade(String stuid, Integer stime) {
        Map<String,Object> map = new HashMap<>();
        map.put("stime",stime);
        map.put("stuid",stuid);
        return gradeMapper.selGrade(map);
    }


    //  查询教师个人信息
    @Override
    public List<TeacherDB> selTea(Integer tid) {
        return gradeMapper.selTea(tid);
    }

    //  查询学分
    @Override
    public Integer selCcredit(String stuid) {
        return gradeMapper.selCcredit(stuid);
    }
}
