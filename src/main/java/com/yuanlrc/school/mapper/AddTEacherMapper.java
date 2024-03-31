package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.TeacherDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddTEacherMapper {

    //  添加教师
    Integer addTeacher(TeacherDB teacherDB);
    //  判断是否要插入新一年分割工号 1要插入，0不用插入
    Integer selectYear();
    //  添加一条分割线
    Integer teaSegmentation();
    //  生成教师工号
    String selTchid();


    //  根据教师工号查询信息
    List<TeacherDB> selTeaMessage(String tchid);
    //  查询sys_role角色id
    String selectTeaRole();

    //  查询教师数量
    Integer selTeacherCount();
}
