package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.TchSelStuExamVO;
import com.yuanlrc.school.service.TchSelStuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TchSelStuExamController {
    @Autowired
    private TchSelStuExamService tchSelStuExamService;

    @RequestMapping("/tchSelExam")
    public String tchSelExam(Model model){
        String tid=MySysUser.loginName();
        List<Map> tchClass = tchSelStuExamService.selTchClass(tid);
        List<Map> tchGrade = tchSelStuExamService.selTchGrade(tid);
        model.addAttribute("tchClass",tchClass);
        model.addAttribute("tchGrade",tchGrade);
        return "view/student/tchSelStuExam";
    }

    @RequestMapping("/tchSelStuExam")
    @ResponseBody
    public LayuiResult<Map> tchSelStuExam(TchSelStuExamVO tchSelStuExamVO, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        String tid=MySysUser.loginName();
        tchSelStuExamVO.setTid(tid);
        List<Map> listAll = tchSelStuExamService.tchSelStuExam(tchSelStuExamVO);
        PageInfo pageInfo = new PageInfo(listAll);
        LayuiResult<Map> result = new LayuiResult<>();
        //这是layui要求返回的json数据格式
        result.setCode(0);
        result.setMsg( "");
        //将全部数据的条数作为count传给前台（一共多少条）
        result.setCount((int) pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        result.setData(pageInfo.getList());
        return result;
    }
}
