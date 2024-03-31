package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.TchSelStuExamVO;

import java.util.List;
import java.util.Map;

public interface TchSelStuExamService {
    //查询教师授课班级
    List<Map> selTchClass(String tid);
    //教师查询学生成绩
    List<Map> tchSelStuExam(TchSelStuExamVO tchSelStuExamVO);
    //查询教师授课年级
    List<Map> selTchGrade(String tid);
}
