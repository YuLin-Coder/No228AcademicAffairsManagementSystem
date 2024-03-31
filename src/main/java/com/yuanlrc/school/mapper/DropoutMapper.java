package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.StudentDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DropoutMapper {
    //  查询所有退学信息
    List<Map> selDropout(Map<String,Object> map);
    //  查询所有信息数量
    int selDropoutCount(StudentDB studentDB);
}
