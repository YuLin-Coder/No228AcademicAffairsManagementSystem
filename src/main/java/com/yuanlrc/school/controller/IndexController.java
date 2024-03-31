package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.NewsinfoDB;
import com.yuanlrc.school.entity.ScheduleDB;
import com.yuanlrc.school.service.NewsService;
import com.yuanlrc.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class IndexController {
    @Autowired
    private NewsService newsService;
    private ScheduleService scheduleService;

    public IndexController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    /**
     * 无登陆主页显示
     */
    @RequestMapping({"home","/"})
    public String index() {
        return "home";
    }

    /**
     * 获取新闻列表
     */
    @RequestMapping("newslist")
    @ResponseBody
    public Object NewsList(NewsinfoDB newsinfoDB, Integer page){
        PageHelper.startPage(page,5);
        List<NewsinfoDB> listAll = newsService.findAllNews(newsinfoDB);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> newsList = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        newsList.put("pages", pageInfo.getPages());
        //将分页后的数据返回（每页要显示的数据）
        newsList.put("data", pageInfo.getList());
        return newsList;
    }


    /**
     * 获取作息时间表
     */
    @RequestMapping("schedulelist")
    @ResponseBody
    public Object ScheduleList(ScheduleDB scheduleDB){
        List<ScheduleDB> listAll = scheduleService.findAllSchedule(scheduleDB);
        Map<String, Object> schedulelist = new HashMap<String, Object>();
        schedulelist.put("code", 0);
        schedulelist.put("data", listAll);
        return schedulelist;
    }

}
