package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.NewsinfoDB;
import com.yuanlrc.school.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("news")
public class NewsController extends BaseController {
    @Autowired
    private NewsService newsService;

    /**
     * 进入发布文章页面
     * @return
     */
    @RequestMapping("addnews")
    public String addnews() {
        return "view/news/addnews";
    }

    /**
     * 进入新闻公示管理页面
     * @return
     */
    @RequestMapping("newscontrol")
    public String newscontrol() {
        return "view/news/newscontrol";
    }


    /**
     * 发布新闻
     */
    @RequestMapping("addingnews")
    @ResponseBody
    public Object addingNews(NewsinfoDB newsinfoDB){
        int r = newsService.addNews(newsinfoDB);
        if(r==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取新闻列表
     */
    @RequestMapping("findallnews")
    @ResponseBody
    public Object findallnews(NewsinfoDB newsinfoDB, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<NewsinfoDB> listAll = newsService.findAllNews(newsinfoDB);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> newsData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        newsData.put("code", 0);
        newsData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        newsData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        newsData.put("data", pageInfo.getList());
        return newsData;
    }

    /**
     * 删除新闻
     * */
    @RequestMapping("deletenews")
    @ResponseBody
    public Object deleteNews(Integer nid){
        int r = newsService.deleteNews(nid);
        if(r==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 编辑新闻
     */
    @RequestMapping("editingnews")
    @ResponseBody
    public Object editNews(NewsinfoDB newsinfoDB){
        int r = newsService.editNews(newsinfoDB);
        if(r==1){
            return true;
        }else{
            return false;
        }
    }

}
