package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.StudentDB;
import com.yuanlrc.school.entity.pageCount;

import java.util.List;
import java.util.Map;

public interface DropoutService {
    //  查询所有退学信息
    List<Map> selDropout(pageCount pageCount, StudentDB studentDB);
    //  查询所有信息数量
    int selDropoutCount(StudentDB studentDB);
}
