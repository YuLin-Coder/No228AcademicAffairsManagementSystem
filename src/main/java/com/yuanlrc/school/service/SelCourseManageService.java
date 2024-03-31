package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelCourseManageService {
    List<DepartmentDB> selDe();
    List<MajorDB> selMa(Integer did);
    List<GradeDB> selGr(Integer mid);
    List<ClassinfoDB> selClass(Integer gid);
    List<StudentDB> selSt(Integer classid);
    List<StuCourseVO> selSc(StuCourseVO stuCourseVO);
    int dropcou(@Param("sid") Integer sid, @Param("cid") Integer cid);
    int updatecou(Integer cid);
    int changesCou(@Param("ccd") Integer ccd, @Param("sid") Integer sid, @Param("cid") Integer cid);
    List<CourseDB> selCo();
    int selStc(@Param("ccd") Integer ccd, @Param("sid") Integer sid);
}
