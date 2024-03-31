package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.CourseTypeDB;
import com.yuanlrc.school.entity.MajorDB;
import com.yuanlrc.school.entity.coursel;
import com.yuanlrc.school.service.courselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class courselServiceImpl implements courselService {
    @Resource
    private com.yuanlrc.school.mapper.courseMapperl courseMapperl;
    @Override
    public List<coursel> selCourse(coursel coursel) {
        return courseMapperl.selCourse(coursel);
    }

    @Override
    public List<MajorDB> selJson() {
        return courseMapperl.selJson();
    }

    @Override
    public List<CourseTypeDB> selCoutu() {
        return courseMapperl.selCoutu();
    }

    @Override
    public int update(coursel coursel) {
        return courseMapperl.update(coursel);
    }

    @Override
    public int addcou(coursel coursel) {
        return courseMapperl.addcou(coursel);
    }

    @Override
    public int delcou(Integer cid) {
        return courseMapperl.delcou(cid);
    }

    @Override
    public int hfcou(Integer cid) {
        return courseMapperl.hfcou(cid);
    }

    @Override
    public int delercou(Integer cid) {
        return courseMapperl.delercou(cid);
    }
}
