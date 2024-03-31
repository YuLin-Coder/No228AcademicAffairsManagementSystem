package com.nsapi.niceschoolapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuanlrc.school.entity.Menu;
import com.yuanlrc.school.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NiceschoolapiApplicationTests {

    @Autowired
    MenuService menuService;

    @Test
    public void contextLoads() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        Object o = menuService.getObj(wrapper.select("max(sort) as sort").isNull("parent_id"));
        System.out.println(o.toString());

    }

    public static void main(String[] args) throws ParseException {
        String strDate = "2018-07-18T08:12:08.000+0000";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+0000'");
        Date date = format.parse(strDate);
        System.out.println(date.toString());
    }

}
