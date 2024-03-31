package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DeleteController {
    @Autowired
    private DeleteService deleteService;

    @RequestMapping("/insertDropout")
    public String insertDropout(String stuid,String sname, Model model){
        model.addAttribute("stuid",stuid);
        model.addAttribute("sname",sname);
        return "view/student/dropout";
    }

    @RequestMapping("delStudent")
    @ResponseBody
    public LayuiResult<Map> delStudent(String stuid, String drreason){
        LayuiResult result = new LayuiResult();
        //  将学生添加至dropout退学信息表
        Integer aa = deleteService.insertDropout(stuid,drreason);
        //  删除学生信息
        Integer deleteStudent = deleteService.deleteStudent(stuid);
        //  删除学生选课信息
        Integer deleteStuCourse = deleteService.deleteStuCourse(stuid);
        //  删除学生成绩表信息
        Integer deleteStuExam = deleteService.deleteStuExam(stuid);
        //  删除教评记录表信息
        Integer deleteEvaluateRecord = deleteService.deleteEvaluateRecord(stuid);
        //  班级表人数-1
        Integer deleteClassinfo = deleteService.deleteClassinfo(stuid);
        //  年级人数-1
        Integer deleteGrade = deleteService.deleteGrade(stuid);
        //  专业人数-1
        Integer deleteMajor = deleteService.deleteMajor(stuid);
        //  系部人数-1
        Integer deleteDepartment = deleteService.deleteDepartment(stuid);
        //  改用户登录状态改为（1）锁定状态
        Integer deleteUser = deleteService.deleteUser(stuid);
        result.setMsg("操作成功");
        return result;
    }
}
