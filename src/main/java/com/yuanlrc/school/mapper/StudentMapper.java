package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //  查询所有学生
    public List<Map> selStudent(Map<String, Object> map);
    //  查询信息总条数
    public int selCount(StudentVO studentVO);

    //  根据id查询一条学生信息
    public List<StudentDB> selStudentId(Integer id);
    //  查询班级
    public List<ClassinfoDB> selClass();
    //  查询政治面貌表
    public List<PoliticsTypeDB> selPolitics();
    //  修改学生信息
    public int updateStudent(StudentDB studentDB);

    //  查询系部
    public List<DepartmentDB> selDepartment();

    //  根据系部查询专业
    public List<MajorDB> selMajorDB(Integer did);
    //  根据专业查询年级
    List<GradeDB> selGradeDB(Integer mid);
    //  根据年级查询班级
    List<ClassinfoDB> selClassinfoDB(Integer gid);
}
