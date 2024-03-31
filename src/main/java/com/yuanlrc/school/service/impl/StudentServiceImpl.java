package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.mapper.StudentMapper;
import com.yuanlrc.school.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    //  查询所有学生
    @Override
    public List<Map> selStudent(StudentVO studentVO, pageCount pageCount) {
        int begin = pageCount.getLimit()*(pageCount.getPage()-1);
        int end = pageCount.getLimit()*pageCount.getPage()-begin;
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("stuid",studentVO.getStuid());
        map.put("sname",studentVO.getSname());
        map.put("did",studentVO.getDid());
        map.put("mid",studentVO.getMid());
        map.put("gid",studentVO.getGid());
        map.put("classid",studentVO.getClassid());
        return studentMapper.selStudent(map);
    }

    //  查询信息总条数
    @Override
    public int selCount(StudentVO studentVO) {
        return studentMapper.selCount(studentVO);
    }

    //  根据id查询一条学生信息
    @Override
    public List<StudentDB> selStudentId(Integer id) {
        return studentMapper.selStudentId(id);
    }

    //  查询班级
    @Override
    public List<ClassinfoDB> selClass() {
        return studentMapper.selClass();
    }

    //  查询政治面貌表
    @Override
    public List<PoliticsTypeDB> selPolitics() {
        return studentMapper.selPolitics();
    }

    //  修改学生信息
    @Override
    public int updateStudent(StudentDB studentDB) {
        return studentMapper.updateStudent(studentDB);
    }


    //  查询系部
    @Override
    public List<DepartmentDB> selDepartment() {
        return studentMapper.selDepartment();
    }


    //  根据系部查询专业
    @Override
    public List<MajorDB> selMajorDB(Integer did) {
        return studentMapper.selMajorDB(did);
    }

    //  根据专业查询年级
    @Override
    public List<GradeDB> selGradeDB(Integer mid) {
        return studentMapper.selGradeDB(mid);
    }

    //  根据年级查询班级
    @Override
    public List<ClassinfoDB> selClassinfoDB(Integer gid) {
        return studentMapper.selClassinfoDB(gid);
    }

}
