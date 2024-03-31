package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.mapper.TchCourseMapper;
import com.yuanlrc.school.service.TchCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TchCourseServiceImpl implements TchCourseService {
    @Resource
    private TchCourseMapper tchCourseMapper;

    //查询全部教师
    @Override
    public List<TeacherDB> findAllTch(TeacherDB teacherDB) {
        return tchCourseMapper.findAllTch(teacherDB);
    }

    //查询全部教师姓名
    @Override
    public List<TeacherDB> findAllTchByName() {
        return tchCourseMapper.findAllTchByName();
    }

    //通过专业查询全部课程
    @Override
    public List<TeacherDB> findAllCourseByMajorName(TchCourseVO tchCourseVO) { return tchCourseMapper.findAllCourseByMajorName(tchCourseVO); }

    //查询级联班级
    @Override
    public List<TeacherDB> findTchCourseClassName(ClassinfoDB classinfoDB) { return tchCourseMapper.findTchCourseClassName(classinfoDB); }

    //查询周
    @Override
    public List<WeeksDB> findAllWeeks() {
        return tchCourseMapper.findAllWeeks();
    }

    //查询节段
    @Override
    public List<ScheduleDB> findAllSchedule() {
        return tchCourseMapper.findAllSchedule();
    }

    //添加教师授课表记录并返回新数据id
    @Override
    public int addOneTchCourse(TchCourseVO tchCourseVO) {
        return tchCourseMapper.addOneTchCourse(tchCourseVO);
    }

    //添加教师授班表记录
    @Override
    public int addOneTchClass(TchCourseVO tchCourseVO) {
        return tchCourseMapper.addOneTchClass(tchCourseVO);
    }

    //查询是否有重复授课
    @Override
    public int findTchCourseFlag(TchCourseVO tchCourseVO) {
        return tchCourseMapper.findTchCourseFlag(tchCourseVO);
    }

    //查询是否有冲突授课
    @Override
    public int findTchCourseDanger(TchCourseVO tchCourseVO) { return tchCourseMapper.findTchCourseDanger(tchCourseVO); }

    //查询指定老师教授所有课程
    @Override
    public List<TchCourseVO> findCourseByTch(TchCourseVO tchCourseVO) { return tchCourseMapper.findCourseByTch(tchCourseVO); }
    //删除教师授课及班级
    @Override
    public int delTchCourse(TchCourseVO tchCourseVO) {
        return tchCourseMapper.delTchCourse(tchCourseVO);
    }

}