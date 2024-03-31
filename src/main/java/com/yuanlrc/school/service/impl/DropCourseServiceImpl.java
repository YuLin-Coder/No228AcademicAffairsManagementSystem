package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.coursel;
import com.yuanlrc.school.mapper.DropCourseMapper;
import com.yuanlrc.school.service.DropCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DropCourseServiceImpl implements DropCourseService {
    @Resource
    private DropCourseMapper dropCourseMapper;
    @Override
    public List<coursel> seledCourse(String cname, Integer sid) {
        return dropCourseMapper.seledCourse(cname,sid);
    }

    @Override
    public int dropcou(Integer sid, Integer cid) {
        return dropCourseMapper.dropcou(sid,cid);
    }

    @Override
    public int updatecou(Integer cid) {
        return dropCourseMapper.updatecou(cid);
    }
}
