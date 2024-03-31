package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.EvTchVO;
import com.yuanlrc.school.entity.EvaluateListDB;
import com.yuanlrc.school.entity.EvaluateRecordDB;
import com.yuanlrc.school.entity.SelEvRecardVO;
import com.yuanlrc.school.mapper.AppraiseMapper;
import com.yuanlrc.school.service.AppraiseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AppraiseServiceImpl implements AppraiseService {
    @Resource
    private AppraiseMapper appraiseMapper;
    //查询全部对应教评的老师
    @Override
    public List<SelEvRecardVO> findAllTch(SelEvRecardVO selEvRecardVO) {
        return appraiseMapper.findAllTch(selEvRecardVO);
    }
    //查询全部教评题目
    @Override
    public List<EvaluateListDB> findAllTM(EvaluateListDB evaluateListDB) {
        return appraiseMapper.findAllTM(evaluateListDB);
    }
    //查询教评状态
    @Override
    public int selOneState(EvaluateRecordDB evaluateRecordDB) {
        return appraiseMapper.selOneState(evaluateRecordDB);
    }
    //添加教评
    @Override
    public int addOneAppraise(EvTchVO evTchVO) {
        return appraiseMapper.addOneAppraise(evTchVO);
    }
    //判断是否有教师成绩记录
    @Override
    public int selTchExamState(EvTchVO evTchVO) {
        return appraiseMapper.selTchExamState(evTchVO);
    }

    //添加教师分数及教评人数
    @Override
    public int addOneTchExam(EvTchVO evTchVO) {
        return appraiseMapper.addOneTchExam(evTchVO);
    }

    //更新教师分数及教评人数
    @Override
    public int updOneTchExam(EvTchVO evTchVO) { return appraiseMapper.updOneTchExam(evTchVO); }
    //删除问题
    @Override
    public int deleteOneEv(Integer elid) { return appraiseMapper.deleteOneEv(elid); }
    //编辑问题
    @Override
    public int editOneEv(EvaluateListDB evaluateListDB) { return appraiseMapper.editOneEv(evaluateListDB); }
    //添加问题
    @Override
    public int addOneEv(EvaluateListDB evaluateListDB) { return appraiseMapper.addOneEv(evaluateListDB); }
}