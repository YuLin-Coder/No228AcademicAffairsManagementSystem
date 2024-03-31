package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.PoliticsTypeDB;
import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.entity.pageCount;
import com.yuanlrc.school.service.DeleteService;
import com.yuanlrc.school.service.StudentService;
import com.yuanlrc.school.service.TeacherService;
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
public class TeacherController {
    @Autowired
    private TeacherService lxxTeacherService;
    @Autowired
    private StudentService lxxStudentService;
    @Autowired
    private DeleteService deleteService;

    // 跳转教师查询页面
    @RequestMapping("/selectTeacher")
    public String selectTeacher(){
        return "view/teacher/selTeacher";
    }


    //  查询教师信息
    @RequestMapping("selTeacher")
    @ResponseBody
    public LayuiResult<Map> selTeacher(TeacherDB teacherDB, pageCount pageCount){
        LayuiResult<Map> result = new LayuiResult<>();
        //  查询所有教师信息/模糊查询教师信息
        List<Map> list = lxxTeacherService.selTeacher(teacherDB,pageCount);
        //  查询符合条件的教师数量
        int count = lxxTeacherService.selTeacherCount(teacherDB);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    //  根据教师编号查询教师信息
    @RequestMapping("/selTeacherId")
    public String selTeacherId(Integer id, Model model){
        List<TeacherDB> tea = lxxTeacherService.selTeacherId(id);
        //  查询政治面貌
        List<PoliticsTypeDB> selpol = lxxStudentService.selPolitics();
        model.addAttribute("tea",tea);
        model.addAttribute("selpol",selpol);
        return "view/teacher/updTeacher";
    }

    //  根据教师编号查询教师详细信息
    @RequestMapping("/selectTeaMessage")
    public String selectTeaMessage(Integer id, Model model){
        List<TeacherDB> tea = lxxTeacherService.selTeacherId(id);
        //  查询政治面貌
        List<PoliticsTypeDB> selpol = lxxStudentService.selPolitics();
        model.addAttribute("tea",tea);
        model.addAttribute("selpol",selpol);
        return "view/teacher/selTchMessage";
    }

    //  修改教师信息
    @RequestMapping("/updateTeacher")
    @ResponseBody
    public LayuiResult<TeacherDB> updTeacher(TeacherDB teacherDB, String birthday) throws Exception{
        LayuiResult result= new LayuiResult();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(birthday);
        teacherDB.setTbirthday(date);
        Integer state = teacherDB.getTchstate();
        Integer tid = teacherDB.getTid();
        if(state == 1){
            //  修改教师为离职状态并逻辑删除
            Integer deleteTeacher = deleteService.deleteTeacher(teacherDB);
            //  删除教师授课信息
            Integer deleteTchCourse = deleteService.deleteTchCourse(tid);
            //  删除教师班级信息
            Integer deleteTchClass = deleteService.deleteTchClass(tid);
            //  删除教师成绩信息
            Integer deleteTchExam = deleteService.deleteTchExam(tid);
            //  删除教评记录信息
            Integer deleteTeaRecord = deleteService.deleteTeaRecord(tid);
            //  改用户登录状态改为（1）锁定状态
            Integer deleteUser = deleteService.deleteUser(teacherDB.getTchid());
            //删除提示
            result.setMsg("修改成功！");
            return result;
        }else{
            int a =lxxTeacherService.updTeacher(teacherDB);
            //删除提示
            result.setMsg("修改成功！");
            return result;
        }
    }

}
