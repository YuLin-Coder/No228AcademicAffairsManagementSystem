package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.EvTchVO;
import com.yuanlrc.school.entity.EvaluateListDB;
import com.yuanlrc.school.entity.EvaluateRecordDB;
import com.yuanlrc.school.entity.SelEvRecardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppraiseMapper {
    //查询全部对应教评的老师
    List<SelEvRecardVO> findAllTch(SelEvRecardVO selEvRecardVO);
    //查询全部教评题目
    List<EvaluateListDB> findAllTM(EvaluateListDB evaluateListDB);
    //查询教评状态
    int selOneState(EvaluateRecordDB evaluateRecordDB);
    //添加教评记录
    int addOneAppraise(EvTchVO evTchVO);
    //判断是否有教师成绩记录
    int selTchExamState(EvTchVO evTchVO);
    //添加教师分数及教评人数
    int addOneTchExam(EvTchVO evTchVO);
    //更新教师分数及教评人数
    int updOneTchExam(EvTchVO evTchVO);
    //删除问题
    int deleteOneEv(Integer elid);
    //编辑问题
    int editOneEv(EvaluateListDB evaluateListDB);
    //添加问题
    int addOneEv(EvaluateListDB evaluateListDB);
}
