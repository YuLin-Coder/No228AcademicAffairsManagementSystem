package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.ScheduleDB;
import com.yuanlrc.school.mapper.ScheduleMapper;
import com.yuanlrc.school.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDB> findAllSchedule(ScheduleDB scheduleDB) {
        return scheduleMapper.findAllSchedule(scheduleDB);
    }
}