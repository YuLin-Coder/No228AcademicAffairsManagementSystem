package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.CourseTypeDB;
import com.yuanlrc.school.entity.MajorDB;
import com.yuanlrc.school.entity.coursel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class courseController {
    @Autowired
    private com.yuanlrc.school.service.courselService courselService;

    @RequestMapping("selCou")
    public String selCourse(){
       // System.out.println("---------------------------------------------------------------------------------------------------------------");
        return "selCou";
    }
    @RequestMapping("sel")
    @ResponseBody
   public Object sel(Integer page, Integer limit, coursel coursel, String cname){

        coursel.setCname(cname);
        PageHelper.startPage(page, limit);
        List<com.yuanlrc.school.entity.coursel> cs = courselService.selCourse(coursel);
        PageInfo pageInfo = new PageInfo(cs);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        System.out.print(cs);
        return tableData;
    }



    @RequestMapping("selJson")
    @ResponseBody
    public Object selJson(){
        List<MajorDB> major  =courselService.selJson();
        return major;
    }
    @RequestMapping("selCoutu")
    @ResponseBody
    public Object selCoutu(){
        List<CourseTypeDB> coursetype=courselService.selCoutu();

        return coursetype;
    }
    @RequestMapping("update")
    @ResponseBody
    public Object update(coursel coursel){
         int update = courselService.update(coursel);
        if(update==1){
            return "修改成功";
        }else{
            return "修改失败";
        }

    }
    @RequestMapping("addcou")
    @ResponseBody
    public Object addcou(coursel coursel){
        int addcou = courselService.addcou(coursel);
        if(addcou==1){
            return "添加成功";
        }else{
            return "添加失败";
        }

    }
    @RequestMapping("delcou")
    @ResponseBody
    public Object delcou(Integer cid){

        int delercou = courselService.delercou(cid);
        //System.out.println(delercou);
        if(delercou>0){
            return "✖  该课程有人在读不可删除";
        }else {
            int add = courselService.delcou(cid);
            if(add==1){
                //return sys.succ;
                return "删除成功";
            }else{
                return "删除失败";
            }
        }

    }

    @RequestMapping("hfcou")
    @ResponseBody
    public Object hfcou(Integer cid){
        int add = courselService.hfcou(cid);
        if(add==1){
            return "恢复成功";
        }else{
            return "恢复失败";
        }
    }
}
