package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class SelectCourseController {
    @Autowired
    private SelectCourseService selectCourseService;
    @RequestMapping("sel")
    public String sel(Model model){
        String stuid= MySysUser.loginName();
        StudentDB sid= selectCourseService.selStudentid(stuid);
        model.addAttribute("sid",sid);
        return "view/student/SelectCourse";
    }
    //查询开设课程
    @RequestMapping("selectCourse")
    @ResponseBody
    public Object index(Integer page, Integer limit, SelectCourseVo selectCourseVo){
        selectCourseVo.setStuid(MySysUser.loginName());
        PageHelper.startPage(page, limit);
        List<SelectCourseVo> listAll = selectCourseService.sel(selectCourseVo);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        //tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
}
//查询课程类别
@ResponseBody
@RequestMapping("seltype")
public Object selType(){
    List<CourseTypeDB> selType = selectCourseService.selType();
    Map<String, Object> tableData = new HashMap<String, Object>();
    //这是layui要求返回的json数据格式
    tableData.put("code", 0);
    tableData.put("data", selType);
    return tableData;
}
//查询是否有该课程
@ResponseBody
@RequestMapping("selcourse")
public Object selcourse(StuCourseDB stuCourseDB, CourseDB courseDB, SelectCourseVo selectCourseVo){
    String msg="";
    if(courseDB.getCselcount().equals(courseDB.getCmaxcount())){
        msg="该课程已选满";
    }
    else {
    int num = selectCourseService.selCourse(stuCourseDB);
   if(num==1){
      msg="您已选择过该课程";
   }
   else{
       int addnum = selectCourseService.addCourse(stuCourseDB);
       if(addnum==1){
           int updatenum = selectCourseService.updateCount(stuCourseDB);
           if(updatenum==1){
               msg="已选择";
           }
       }
   }
    }
    return  msg;
}
}
