package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.StudentDB;
import com.yuanlrc.school.entity.pageCount;
import com.yuanlrc.school.mapper.DropoutMapper;
import com.yuanlrc.school.service.DropoutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DropoutServiceImpl implements DropoutService {
    @Resource
    private DropoutMapper dropoutMapper;

    //  查询所有退学信息
    @Override
    public List<Map> selDropout(pageCount pageCount, StudentDB studentDB) {
        int begin = pageCount.getLimit()*(pageCount.getPage()-1);
        int end = pageCount.getLimit()*pageCount.getPage()-begin;
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("stuid",studentDB.getStuid());
        map.put("sname",studentDB.getSname());
        return dropoutMapper.selDropout(map);
    }

    //  查询所有信息数量
    @Override
    public int selDropoutCount(StudentDB studentDB) {
        return dropoutMapper.selDropoutCount(studentDB);
    }
}
