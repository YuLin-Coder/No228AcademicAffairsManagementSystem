package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.TeacherDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    //  查询所有教师
    public List<Map> selTeacher(Map<String, Object> map);
    //  查询教师数量
    public int selTeacherCount(TeacherDB teacherDB);
    //  根据教师编号查询教师信息
    public List<TeacherDB> selTeacherId(Integer id);
    //  修改教师信息
    public int updTeacher(TeacherDB teacherDB);
}
