package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.SelAllExamVO;

import java.util.List;
import java.util.Map;

public interface SelAllExamMapper {
    List<Map> selAllExam(SelAllExamVO selAllExamVO);
}
