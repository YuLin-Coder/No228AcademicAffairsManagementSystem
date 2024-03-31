package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    // 跳转学生查询页面
    @RequestMapping("/selectStudent")
    public String selectStudent(){
        return "view/student/selStudent";
    }


    //  查询所有学生
    @RequestMapping("selStudent")
    @ResponseBody
    public LayuiResult<Map> selectStu(pageCount pageCount, StudentVO studentVO){
        LayuiResult<Map> result = new LayuiResult<>();
        List<Map> list = studentService.selStudent(studentVO,pageCount);
        int count = studentService.selCount(studentVO);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    //  查询所有专业
    @RequestMapping("selDepartment")
    @ResponseBody
    public LayuiResult<Map> selDepartment(){
        List<DepartmentDB> selDepartment = studentService.selDepartment();
        LayuiResult result = new LayuiResult();
        result.setData(selDepartment);
        return result;
    }

    //  根据系部查询专业
    @RequestMapping("selectdid")
    @ResponseBody
    public LayuiResult<Map> selMajorDB(Integer did){
        List<MajorDB> major  =studentService.selMajorDB(did);
        LayuiResult result = new LayuiResult();
        result.setData(major);
        return result;
    }
    //  根据专业查询年级
    @RequestMapping("selectmid")
    @ResponseBody
    public LayuiResult<Map> selGradeDB(Integer mid){
        List<GradeDB> grade = studentService.selGradeDB(mid);
        LayuiResult result = new LayuiResult();
        result.setData(grade);
        return result;
    }

    //  根据年级查询班级
    @RequestMapping("selectgid")
    @ResponseBody
    public LayuiResult<Map> selClassinfoDB(Integer gid){
        List<ClassinfoDB> classinfo = studentService.selClassinfoDB(gid);
        LayuiResult result = new LayuiResult();
        result.setData(classinfo);
        return result;
    }


    //  根据id查询一条学生信息以此进行修改
    @RequestMapping("/selStudentId")
    public String selStudentId(Integer id, Model model){
        //  查询学生信息
        List<StudentDB> stu = studentService.selStudentId(id);
        //  查询班级
        List<ClassinfoDB> cls = studentService.selClass();
        //  查询政治面貌表
        List<PoliticsTypeDB> stupol = studentService.selPolitics();
        model.addAttribute("stu",stu);
        model.addAttribute("cls",cls);
        model.addAttribute("stupol",stupol);
        return "view/student/updStudent";
    }

    //  根据id查询显示学生详细信息
    @RequestMapping("/selectMessage")
    public String selectMessage(Integer id, Model model){
        //  查询学生信息
        List<StudentDB> stu = studentService.selStudentId(id);
        //  查询班级
        List<ClassinfoDB> cls = studentService.selClass();
        //  查询政治面貌表
        List<PoliticsTypeDB> stupol = studentService.selPolitics();
        model.addAttribute("stu",stu);
        model.addAttribute("cls",cls);
        model.addAttribute("stupol",stupol);
        return "view/student/selStuExam";
    }

    //  修改用户信息
    @RequestMapping("/updateStudent")
    @ResponseBody
    public LayuiResult<StudentDB> updateStudent(StudentDB studentDB, String birthday) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(birthday);
        studentDB.setSbirthday(date);
        studentService.updateStudent(studentDB);
        LayuiResult result= new LayuiResult();
        //删除提示
        result.setMsg("修改成功！");
        return result;
    }
}
