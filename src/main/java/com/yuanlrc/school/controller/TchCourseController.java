package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.service.TchCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Controller
@RequestMapping("tchcoursemanage")
public class TchCourseController extends BaseController {
    @Autowired
    private TchCourseService tchCourseService;

    /**
     * 进入教师授课管理页面
     */
    @RequestMapping("tchcoursemanage")
    public String classmanage() {
        return "view/teacher/tchcoursemanage";
    }


/*******************************************************************查询*********************************************************************/

    /**
     * 查询全部教师
     */
    @RequestMapping("findalltch")
    @ResponseBody
    public Object findAllTch(TeacherDB teacherDB, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findAllTch(teacherDB);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tchData = new HashMap<String, Object>();
        tchData.put("code", 0);
        tchData.put("msg", "");
        tchData.put("count", pageInfo.getTotal());
        tchData.put("data", pageInfo.getList());
        return tchData;
    }
    /**
     * 查询全部教师姓名
     */
    @RequestMapping("findalltchbyname")
    @ResponseBody
    public Object findAllTchByName(Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findAllTchByName();
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tchData = new HashMap<String, Object>();
        tchData.put("code", 0);
        tchData.put("msg", "");
        tchData.put("count", pageInfo.getTotal());
        tchData.put("data", pageInfo.getList());
        return tchData;
    }
    /**
     * 通过专业查询全部课程
     */
    @RequestMapping("findallcoursebymajorname")
    @ResponseBody
    public Object findAllCourseByMajorName(TchCourseVO tchCourseVO, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findAllCourseByMajorName(tchCourseVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> csData = new HashMap<String, Object>();
        csData.put("code", 0);
        csData.put("msg", "");
        csData.put("count", pageInfo.getTotal());
        csData.put("data", pageInfo.getList());
        return csData;
    }
    /**
     * 查询教师授课中级联班级
     */
    @RequestMapping("findtchcourseclassname")
    @ResponseBody
    public Object findTchCourseClassName(ClassinfoDB classinfoDB, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findTchCourseClassName(classinfoDB);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> cnData = new HashMap<String, Object>();
        cnData.put("code", 0);
        cnData.put("msg", "");
        cnData.put("count", pageInfo.getTotal());
        cnData.put("data", pageInfo.getList());
        return cnData;
    }

    /**
     * 查询周
     */
    @RequestMapping("findallweeks")
    @ResponseBody
    public Object findAllWeeks(Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<WeeksDB> listAll = tchCourseService.findAllWeeks();
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> wData = new HashMap<String, Object>();
        wData.put("code", 0);
        wData.put("msg", "");
        wData.put("count", pageInfo.getTotal());
        wData.put("data", pageInfo.getList());
        return wData;
    }
    /**
     * 查询节段
     */
    @RequestMapping("findallschedule")
    @ResponseBody
    public Object findAllSchedule(Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<ScheduleDB> listAll = tchCourseService.findAllSchedule();
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> sData = new HashMap<String, Object>();
        sData.put("code", 0);
        sData.put("msg", "");
        sData.put("count", pageInfo.getTotal());
        sData.put("data", pageInfo.getList());
        return sData;
    }


    /**
     * 添加教师授课表记录并返回新数据id
     */

    @RequestMapping("addonetchcourse")
    @ResponseBody
    public Object addOneTchCourse(TchCourseVO tchCourseVO){
        int flag = tchCourseService.findTchCourseFlag(tchCourseVO);
        if(flag>0){
            return false;
        }else{
            int d = tchCourseService.findTchCourseDanger(tchCourseVO);
            if (d>0){
                return false;
            }else {
                int r = tchCourseService.addOneTchCourse(tchCourseVO);
                if(r>0){
                    int r2 = tchCourseService.addOneTchClass(tchCourseVO);
                    if(r2>0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

        }

    }

    /**
     * 查询指定老师教授所有课程
     */
    @RequestMapping("findcoursebytch")
    @ResponseBody
    public Object findCourseByTch(TchCourseVO tchCourseVO,Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TchCourseVO> listAll = tchCourseService.findCourseByTch(tchCourseVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> sData = new HashMap<String, Object>();
        sData.put("code", 0);
        sData.put("msg", "");
        sData.put("count", pageInfo.getTotal());
        sData.put("data", pageInfo.getList());
        return sData;
    }

    /**
     * 教师授课及班级删除
     */

    @RequestMapping("deltchcourse")
    @ResponseBody
    public Object delTchCourse(TchCourseVO tchCourseVO){
        int flag = tchCourseService.delTchCourse(tchCourseVO);
        if(flag>0){
            return true;
        }else {
            return false;
        }

    }

}
