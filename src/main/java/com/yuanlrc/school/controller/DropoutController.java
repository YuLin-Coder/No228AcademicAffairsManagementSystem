package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.StudentDB;
import com.yuanlrc.school.entity.pageCount;
import com.yuanlrc.school.service.DropoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DropoutController {
    @Autowired
    private DropoutService dropoutService;

    //  跳转页面
    @RequestMapping("/dropoutPage")
    public String dropoutPage(){
        return "view/student/selDropout";
    }

    @RequestMapping("selDropout")
    @ResponseBody
    public LayuiResult<Map> selDropout(pageCount pageCount, StudentDB studentDB){
        LayuiResult<Map> result = new LayuiResult<>();
        //  查询所有退学信息
        List<Map> selDropout =  dropoutService.selDropout(pageCount,studentDB);
        //  查询所有信息数量
        int count = dropoutService.selDropoutCount(studentDB);
        result.setData(selDropout);
        result.setCount(count);
        return result;
    }
}
