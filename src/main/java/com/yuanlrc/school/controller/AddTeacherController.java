package com.yuanlrc.school.controller;

import com.yuanlrc.school.entity.LayuiResult;
import com.yuanlrc.school.entity.PoliticsTypeDB;
import com.yuanlrc.school.entity.TeacherDB;
import com.yuanlrc.school.service.AddTeacherService;
import com.yuanlrc.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AddTeacherController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AddTeacherService addTeacherService;

    @RequestMapping("/addTeacherPage")
    public String addTeacherPage(Model model){
        //  查询政治面貌表
        List<PoliticsTypeDB> stupol = studentService.selPolitics();
        model.addAttribute("stupol",stupol);
        return "view/teacher/addTeacher";
    }



    //  添加教师
    @RequestMapping("addTeacher")
    @ResponseBody
    public LayuiResult<TeacherDB> addTeacher(TeacherDB teacherDB, String birthday, String tertime) throws Exception{
        LayuiResult<TeacherDB> result= new LayuiResult<>();
        //  将接收到的时间进行类型转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(birthday);
        Date date2=format.parse(tertime);
        teacherDB.setTbirthday(date1);
        teacherDB.setEntertime(date2);
        //  查询教师数量
        Integer teacount = addTeacherService.selTeacherCount();
        if(teacount == 0){
            //  添加一条分割线
            Integer aa = addTeacherService.teaSegmentation();
        }
        //  判断是否要插入新一年分割工号 1要插入，0不用插入
        Integer year = addTeacherService.selectYear();
        if(year>0){
            //  添加一条分割线
            Integer aa = addTeacherService.teaSegmentation();
        }
        //  生成教师工号
        String tchid = addTeacherService.selTchid();
        teacherDB.setTchid(tchid);
        teacherDB.setTid(Integer.valueOf(tchid));
        //  添加教师
        Integer addTeacher = addTeacherService.addTeacher(teacherDB);

        //  根据教师工号查询信息
        List<TeacherDB> tea = addTeacherService.selTeaMessage(teacherDB.getTchid());

        //  查询sys_role角色id
        String id = addTeacherService.selectTeaRole();
        result.setData(tea);
        result.setMsg(id);
        return result;
    }
}
