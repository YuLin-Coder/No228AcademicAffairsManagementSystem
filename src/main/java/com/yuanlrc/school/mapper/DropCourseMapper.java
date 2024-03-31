package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.coursel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DropCourseMapper {
    //多个参数传递需要加@param注解传递
    List<coursel> seledCourse(@Param("cname") String cname, @Param("sid") Integer sid);
    int dropcou(@Param("sid") Integer sid, @Param("cid") Integer cid);
    int updatecou(Integer cid);
}
