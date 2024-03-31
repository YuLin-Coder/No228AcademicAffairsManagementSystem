package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.service.SelCourseManageService;
import com.yuanlrc.school.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelCourseManController {
    @Autowired
    private SelCourseManageService selCourseManageService;

    @RequestMapping("selCourses")
    public String selCourses(){
        System.out.println("----------------------");
        return "SelCourseMan";
    }
    @RequestMapping("selSc")
    @ResponseBody
    public Object selSc(Integer page, Integer limit, StuCourseVO stuCourseVO){
        System.out.println(stuCourseVO.getSname());
        PageHelper.startPage(page, limit);
        List<StuCourseVO> stuCourseVOS = selCourseManageService.selSc(stuCourseVO);
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
    @RequestMapping("selDe")
    @ResponseBody
    public Object selDe(){
        List<DepartmentDB> departmentDBS = selCourseManageService.selDe();
        //System.out.println(departmentDBS);
        return departmentDBS;
    }
    @RequestMapping("selMa")
    @ResponseBody
    public Object selMa(Integer did){
        //System.out.println(did);
        List<MajorDB> majors = selCourseManageService.selMa(did);
        //System.out.println(majors);
        return majors;
    }
    @RequestMapping("selGr")
    @ResponseBody
    public Object selGr(Integer mid){
        //System.out.println(mid);
        List<GradeDB> gradeDBS = selCourseManageService.selGr(mid);
       // System.out.println(gradeDBS);
        return gradeDBS;
    }
    @RequestMapping("selCl")
    @ResponseBody
    public Object selCl(Integer gid){
       // System.out.println(gid);
        List<ClassinfoDB> classinfoDBS = selCourseManageService.selClass(gid);
       // System.out.println(classinfoDBS);
        return classinfoDBS;
    }
    @RequestMapping("selSt")
    @ResponseBody
    public Object selSt(Integer classid){
        //System.out.println(classid);
        List<StudentDB> studentDBS = selCourseManageService.selSt(classid);
       // System.out.println(studentDBS);
        return studentDBS;
    }
    @RequestMapping("selCo")
    @ResponseBody
    public Object selCo(){
        //System.out.println(classid);
        List<CourseDB> courseDBS = selCourseManageService.selCo();
        // System.out.println(studentDBS);
        return courseDBS;
    }
    //退课
    @RequestMapping("dropCous")
    @ResponseBody
    public Object dropCous(Integer sid,Integer cid){

        int dropcou = selCourseManageService.dropcou(sid, cid);
        int updatecou = selCourseManageService.updatecou(cid);
        if(dropcou>0 && updatecou>0){
            return "退课成功";
        }else{
            return "退课失败,请稍后再试或联系管理员";
        }
    }
    //换课
    @RequestMapping("changesCou")
    @ResponseBody
    public Object changesCou( Integer ccd,  Integer sid,Integer cid) {
        /*System.out.println(ccd+"8888888");
        System.out.println(sid+"-----"+cid);*/
        int i = selCourseManageService.selStc(ccd, sid);

        if (i > 0) {
            return "该学生已经选过这门课";
        } else {
            int dropcou = selCourseManageService.changesCou(ccd, sid, cid);
            if (dropcou > 0) {
                return "换课成功";
            } else {
                return "退课失败,请稍后再试或联系管理员";
            }
        }
    }
}
