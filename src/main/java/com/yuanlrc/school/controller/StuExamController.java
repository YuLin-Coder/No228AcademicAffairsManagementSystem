package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StuExamController {
    @Autowired
    private StudentExamService studentExamService;
    @RequestMapping("selstudentExam")
    public String selCourses(){
        return "StudentExam";
    }
    @RequestMapping("selScs")
    @ResponseBody
    public Object selSc(Integer page, Integer limit, StuExamVO stuExamVO){
        stuExamVO.setTid(Integer.valueOf(MySysUser.loginName()));
        PageHelper.startPage(page, limit);
        List<StuExamVO> stuCourseVOS = studentExamService.selScs(stuExamVO);
        PageInfo pageInfo = new PageInfo(stuCourseVOS);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        // System.out.print(cs);
        return tableData;
    }

    //下面是下拉框
    @RequestMapping("selDes")
    @ResponseBody
    public Object selDes(){
        List<DepartmentDB> departmentDBS = studentExamService.selDes();
        //System.out.println(departmentDBS);
        return departmentDBS;
    }
    @RequestMapping("selMas")
    @ResponseBody
    public Object selMas(Integer did){
        //System.out.println(did);
        List<MajorDB> majors = studentExamService.selMas(did);
        //System.out.println(majors);
        return majors;
    }
    @RequestMapping("selGrs")
    @ResponseBody
    public Object selGrs(Integer mid){
        //System.out.println(mid);
        List<GradeDB> gradeDBS = studentExamService.selGrs(mid);
        // System.out.println(gradeDBS);
        return gradeDBS;
    }
    @RequestMapping("selCls")
    @ResponseBody
    public Object selCls(Integer gid){
         System.out.println(gid);
        List<ClassinfoDB> classinfoDBS = studentExamService.selClasss(gid);
        // System.out.println(classinfoDBS);
        return classinfoDBS;
    }
    @ResponseBody
    @RequestMapping("selmessage")
    public Object selmessage(StuExamVO stuExamVO){
        String msg="";
        int i = studentExamService.selExam(stuExamVO);
        if(i==1){
           msg="请不要重复导入成绩";
        }else{
        int num = studentExamService.add(stuExamVO);
        if (num==1){
            msg="添加成功";
        }
        else {
            msg="添加失败";
        }
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping("saveupdate")
    public  Object saveupdate(StuExamDB stuExamDB){
        String msg="";
        int nums = studentExamService.updateExam(stuExamDB);
        if(nums==1){
            msg="修改成功";
        }
        return msg;
    }
}
