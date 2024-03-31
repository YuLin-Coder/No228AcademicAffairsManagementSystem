package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.*;

import java.util.List;

public interface StudentExamService {
    List<DepartmentDB> selDes();
    List<MajorDB> selMas(Integer did);
    List<GradeDB> selGrs(Integer mid);
    List<ClassinfoDB> selClasss(Integer gid);
    List<StuExamVO> selScs(StuExamVO stuExamVO);
    int add(StuExamVO stuExamVO);
    int selExam(StuExamVO stuExamVO);
    int updateExam(StuExamDB stuExamDB);
}
