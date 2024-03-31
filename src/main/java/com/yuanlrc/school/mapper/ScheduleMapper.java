package com.yuanlrc.school.mapper;

import com.yuanlrc.school.entity.ScheduleDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<ScheduleDB> findAllSchedule(ScheduleDB scheduleDB);
    /*int deleteNews(Integer nId);
    int addNews(NewsDB news);
    int editNews(NewsDB news);*/
}
