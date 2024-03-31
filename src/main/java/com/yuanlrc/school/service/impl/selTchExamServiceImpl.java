package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.SelTchExamVO;
import com.yuanlrc.school.mapper.SelTchExamMapper;
import com.yuanlrc.school.service.SelTchExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class selTchExamServiceImpl implements SelTchExamService {
    @Resource
    private SelTchExamMapper selTchExamMapper;

    @Override
    public List<Map> selTchExam(SelTchExamVO selTchExamVO) {
        return selTchExamMapper.selTchExam(selTchExamVO);
    }
}
