package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.SelAllExamVO;
import com.yuanlrc.school.service.SelAllExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SelStuAllExamController {
    @Autowired
    private SelAllExamService selAllExamService;
    @RequestMapping("/selStuAllExam")
    public String selStuAllExam(){
        return "view/student/selStuAllExam";
    }
    @RequestMapping("/selAllExam")
    @ResponseBody
    public LayuiResult<Map> selAllExam(SelAllExamVO selAllExamVO, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<Map> exam = selAllExamService.selAllExam(selAllExamVO);
        PageInfo pageInfo = new PageInfo(exam);
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
