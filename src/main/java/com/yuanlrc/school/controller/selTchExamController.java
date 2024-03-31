package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.SelTchExamVO;
import com.yuanlrc.school.service.SelTchExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class selTchExamController {
    @Autowired
    private SelTchExamService selTchExamService;

    @RequestMapping("/tchExam")
    public String tchExam(){
        return "view/teacher/selTchExam";
    }

    @RequestMapping("/selTchExam")
    @ResponseBody
    public LayuiResult<Map> selTchExam(SelTchExamVO selTchExamVO, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<Map> selTchExam = selTchExamService.selTchExam(selTchExamVO);
        PageInfo pageInfo = new PageInfo(selTchExam);
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
