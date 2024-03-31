package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.CourseTypeDB;
import com.yuanlrc.school.entity.MajorDB;
import com.yuanlrc.school.entity.coursel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface courseMapperl {
    List<coursel> selCourse(coursel coursel);
    List<MajorDB> selJson();
    List<CourseTypeDB> selCoutu();
    int update(coursel coursel);
    int addcou(coursel coursel);
    int delcou(Integer cid);
    int hfcou(Integer cid);
    int delercou(Integer cid);
}
