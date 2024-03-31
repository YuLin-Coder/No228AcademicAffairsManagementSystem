package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.TchSelStuExamVO;
import com.yuanlrc.school.mapper.TchSelStuExamMapper;
import com.yuanlrc.school.service.TchSelStuExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TchSelStuExamServiceImpl implements TchSelStuExamService {

    @Resource
    private TchSelStuExamMapper tchSelStuExamMapper;

    @Override
    public List<Map> selTchClass(String tid) {
        return tchSelStuExamMapper.selTchClass(tid);
    }

    @Override
    public List<Map> tchSelStuExam(TchSelStuExamVO tchSelStuExamVO) {
        return tchSelStuExamMapper.tchSelStuExam(tchSelStuExamVO);
    }

    @Override
    public List<Map> selTchGrade(String tid) {
        return tchSelStuExamMapper.selTchGrade(tid);
    }

}
