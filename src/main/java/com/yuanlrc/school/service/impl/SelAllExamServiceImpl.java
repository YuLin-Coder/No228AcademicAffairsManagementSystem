package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.SelAllExamVO;
import com.yuanlrc.school.mapper.SelAllExamMapper;
import com.yuanlrc.school.service.SelAllExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SelAllExamServiceImpl implements SelAllExamService {
    @Resource
    private SelAllExamMapper selAllExamMapper;
    @Override
    public List<Map> selAllExam(SelAllExamVO selAllExamVO) {
        return selAllExamMapper.selAllExam(selAllExamVO);
    }
}
