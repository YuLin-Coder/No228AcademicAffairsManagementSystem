package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.TchSelStuExamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TchSelStuExamMapper {
    //查询教师授课班级
    List<Map> selTchClass(String tid);
    //教师查询学生成绩
    List<Map> tchSelStuExam(TchSelStuExamVO tchSelStuExamVO);
    //查询教师授课年级
    List<Map> selTchGrade(String tid);

}

