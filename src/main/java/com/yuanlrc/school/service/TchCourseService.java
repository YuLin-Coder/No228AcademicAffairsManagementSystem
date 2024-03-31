package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.*;

import java.util.List;

public interface TchCourseService {
    //查询全部教师
    List<TeacherDB> findAllTch(TeacherDB teacherDB);
    //查询全部教师姓名
    List<TeacherDB> findAllTchByName();
    //通过专业查询全部课程
    List<TeacherDB> findAllCourseByMajorName(TchCourseVO tchCourseVO);
    //查询级联班级
    List<TeacherDB> findTchCourseClassName(ClassinfoDB classinfoDB);
    //查询周
    List<WeeksDB> findAllWeeks();
    //查询节段
    List<ScheduleDB> findAllSchedule();
    //添加教师授课表记录并返回新数据id
    int addOneTchCourse(TchCourseVO tchCourseVO);
    //添加教师授班表记录
    int addOneTchClass(TchCourseVO tchCourseVO);
    //查询是否有重复授课
    int findTchCourseFlag(TchCourseVO tchCourseVO);
    //查询是否有冲突授课
    int findTchCourseDanger(TchCourseVO tchCourseVO);
    //查询指定老师教授所有课程
    List<TchCourseVO> findCourseByTch(TchCourseVO tchCourseVO);
    //删除教师授课及班级
    int delTchCourse(TchCourseVO tchCourseVO);
}