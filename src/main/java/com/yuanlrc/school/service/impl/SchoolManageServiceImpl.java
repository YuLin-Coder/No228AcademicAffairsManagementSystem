package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.mapper.SchoolManageMapper;
import com.yuanlrc.school.service.SchoolManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SchoolManageServiceImpl implements SchoolManageService {
    @Resource
    private SchoolManageMapper schoolManageMapper;
    /**
     * 系部管理
     */
    //查询全部系部
    @Override
    public List<SchoolManageVO> findAllDpm(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.findAllDpm(schoolManageVO);
    }
    //添加系部
    @Override
    public int addOneDpm(DepartmentDB departmentDB) {
        return schoolManageMapper.addOneDpm(departmentDB);
    }
    //编辑系部
    @Override
    public int editOneDpm(DepartmentDB departmentDB) {
        return schoolManageMapper.editOneDpm(departmentDB);
    }
    //删除系部
    @Override
    public int delOneDpm(Integer did) {
        return schoolManageMapper.delOneDpm(did);
    }
    /**
     * 专业管理
     */
    //查询全部专业
    @Override
    public List<SchoolManageVO> findAllMajor(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.findAllMajor(schoolManageVO);
    }
    //添加专业
    @Override
    public int addOneMajor(MajorDB majorDB) {
        return schoolManageMapper.addOneMajor(majorDB);
    }
    //编辑专业
    @Override
    public int editOneMajor(MajorDB majorDB) {
        return schoolManageMapper.editOneMajor(majorDB);
    }
    //删除专业
    @Override
    public int delOneMajor(Integer mid) {
        return schoolManageMapper.delOneMajor(mid);
    }

    /**
     * 年级管理
     */
    //查询全部年级
    @Override
    public List<SchoolManageVO> findAllGrade(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.findAllGrade(schoolManageVO);
    }
    //级联系部查询对应专业
    @Override
    public List<SchoolManageVO> jlSelMajor(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.jlSelMajor(schoolManageVO);
    }
    //添加年级
    @Override
    public int addOneGrade(GradeDB gradeDB) {
        return schoolManageMapper.addOneGrade(gradeDB);
    }
    //编辑年级
    @Override
    public int editOneGrade(GradeDB gradeDB) {
        return schoolManageMapper.editOneGrade(gradeDB);
    }
    //删除年级
    @Override
    public int delOneGrade(Integer gid) {
        return schoolManageMapper.delOneGrade(gid);
    }

    /**
     * 班级管理
     */
    //查询全部班级
    @Override
    public List<SchoolManageVO> findAllClass(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.findAllClass(schoolManageVO);
    }
    //级联专业查询对应年级
    @Override
    public List<SchoolManageVO> jlSelGrade(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.jlSelGrade(schoolManageVO);
    }
    //添加班级
    @Override
    public int addOneClass(ClassinfoDB classinfoDB) {
        return schoolManageMapper.addOneClass(classinfoDB);
    }
    //编辑班级
    @Override
    public int editOneClass(ClassinfoDB classinfoDB) {
        return schoolManageMapper.editOneClass(classinfoDB);
    }
    //删除班级
    @Override
    public int delOneClass(Integer classid) {
        return schoolManageMapper.delOneClass(classid);
    }

    /**
     * 条件查询
     */
    //条件查询classname
    @Override
    public List<SchoolManageVO> tjSelClass(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.tjSelClass(schoolManageVO);
    }
    //条件查询department
    @Override
    public List<SchoolManageVO> tjSelDpm(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.tjSelDpm(schoolManageVO);
    }
    //条件查询major
    @Override
    public List<SchoolManageVO> tjSelMajor(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.tjSelMajor(schoolManageVO);
    }
    //条件查询grade
    @Override
    public List<SchoolManageVO> tjSelGrade(SchoolManageVO schoolManageVO) {
        return schoolManageMapper.tjSelGrade(schoolManageVO);
    }
    /**
     * 重复验证
     */
    @Override
    public int checkOneDpm(DepartmentDB departmentDB) {
        return schoolManageMapper.checkOneDpm(departmentDB);
    }

    @Override
    public int checkOneMajor(MajorDB majorDB) {
        return schoolManageMapper.checkOneMajor(majorDB);
    }

    @Override
    public int checkOneGrade(GradeDB gradeDB) {
        return schoolManageMapper.checkOneGrade(gradeDB);
    }

    @Override
    public int checkOneClass(ClassinfoDB classinfoDB) {
        return schoolManageMapper.checkOneClass(classinfoDB);
    }
}