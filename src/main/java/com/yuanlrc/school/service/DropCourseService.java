package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.coursel;

import java.util.List;

public interface DropCourseService {
    List<coursel> seledCourse(String cname, Integer sid);
    int dropcou(Integer sid, Integer cid);
    int updatecou(Integer cid);
}
