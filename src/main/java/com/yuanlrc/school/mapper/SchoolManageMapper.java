package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolManageMapper {
    /**
     * 系部管理
     */
    //查询全部系部
    List<SchoolManageVO> findAllDpm(SchoolManageVO schoolManageVO);
    //添加系部
    int addOneDpm(DepartmentDB departmentDB);
    //编辑系部
    int editOneDpm(DepartmentDB departmentDB);
    //删除系部
    int delOneDpm(Integer did);

    /**
     * 专业管理
     */
    //查询全部专业
    List<SchoolManageVO> findAllMajor(SchoolManageVO schoolManageVO);
    //添加专业
    int addOneMajor(MajorDB majorDB);
    //编辑专业
    int editOneMajor(MajorDB majorDB);
    //删除专业
    int delOneMajor(Integer mid);

    /**
     * 年级管理
     */
    //查询全部系部
    List<SchoolManageVO> findAllGrade(SchoolManageVO schoolManageVO);
    //级联系部查询对应专业
    List<SchoolManageVO> jlSelMajor(SchoolManageVO schoolManageVO);
    //添加年级
    int addOneGrade(GradeDB gradeDB);
    //编辑年级
    int editOneGrade(GradeDB gradeDB);
    //删除年级
    int delOneGrade(Integer gid);

    /**
     * 班级管理
     */
    //查询全部班级
    List<SchoolManageVO> findAllClass(SchoolManageVO schoolManageVO);
    //级联专业查询对应年级
    List<SchoolManageVO> jlSelGrade(SchoolManageVO schoolManageVO);
    //添加班级
    int addOneClass(ClassinfoDB classinfoDB);
    //编辑班级
    int editOneClass(ClassinfoDB classinfoDB);
    //删除班级
    int delOneClass(Integer classid);

    /**
     * 条件查询
     */
    //条件查询classname
    List<SchoolManageVO> tjSelClass(SchoolManageVO schoolManageVO);
    //条件查询department
    List<SchoolManageVO> tjSelDpm(SchoolManageVO schoolManageVO);
    //条件查询major
    List<SchoolManageVO> tjSelMajor(SchoolManageVO schoolManageVO);
    //条件查询grade
    List<SchoolManageVO> tjSelGrade(SchoolManageVO schoolManageVO);

    /**
     * 重复验证
     */
    int checkOneDpm(DepartmentDB departmentDB);
    int checkOneMajor(MajorDB majorDB);
    int checkOneGrade(GradeDB gradeDB);
    int checkOneClass(ClassinfoDB classinfoDB);
}
