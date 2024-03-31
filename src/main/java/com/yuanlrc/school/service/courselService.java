package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.CourseTypeDB;
import com.yuanlrc.school.entity.MajorDB;
import com.yuanlrc.school.entity.coursel;

import java.util.List;

public interface courselService {
    List<coursel> selCourse(coursel coursel);
    List<MajorDB> selJson();
    List<CourseTypeDB> selCoutu();
    int update(coursel coursel);
    int addcou(coursel coursel);
    int delcou(Integer cid);
    int hfcou(Integer cid);
    int delercou(Integer cid);
}
