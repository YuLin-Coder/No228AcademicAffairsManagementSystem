package com.yuanlrc.school.controller;

import com.yuanlrc.school.common.config.MySysUser;
import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/selectGrade")
    public String pageSelgrade(Model model){
        String stuid = MySysUser.loginName();
        //  查询学生个人信息
        List<Map> selStudentMessage = gradeService.selStudentMessage(stuid);
        //  查询学分
        Integer ccredit =  gradeService.selCcredit(stuid);
        model.addAttribute("selStudentMessage",selStudentMessage);
        model.addAttribute("redit",ccredit);
        return "view/student/selGrade";
    }

    //  根据学期查看成绩
    @RequestMapping("selGrade")
    @ResponseBody
    public LayuiResult<Map> selGrade(Integer stime){
        String stuid = MySysUser.loginName();
        if(stime == null){
            List<Map> selGrade = gradeService.selGrade(stuid,1);
            LayuiResult result = new LayuiResult();
            result.setData(selGrade);
            return result;
        }else{
            List<Map> selGrade = gradeService.selGrade(stuid,stime);
            LayuiResult result = new LayuiResult();
            result.setData(selGrade);
            return result;
        }

    }

    //  管理员/教师 详情页面查询学生成绩
    @RequestMapping("/selExam")
    public String selExam(String stuid, Integer stime, Model model){
        if(stime == null){
            stime = 1;
            List<Map> selGrade = gradeService.selGrade(stuid,stime);
            model.addAttribute("selGrade",selGrade);
            model.addAttribute("stuid",stuid);
            model.addAttribute("stime",stime);
            return "view/student/selStuExam";
        }else{
            List<Map> selGrade = gradeService.selGrade(stuid,stime);
            model.addAttribute("selGrade",selGrade);
            model.addAttribute("stuid",stuid);
            model.addAttribute("stime",stime);
            return "view/student/selStuExam";
        }


    }


}
