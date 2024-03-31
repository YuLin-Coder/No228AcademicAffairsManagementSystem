package com.yuanlrc.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanlrc.school.entity.Menu;
import com.yuanlrc.school.entity.ShowMenuVo;

import java.util.List;
import java.util.Map;

public interface MenuService extends IService<Menu> {

    List<ShowMenuVo> getShowMenuByUser(String userId);

    List<Menu> selectAllMenus(Map<String,Object> map);

    List<Menu> selectAllMenuList(Map<String,Object> map);

    Menu selectById(String parentId);

    Integer getCountByName(String name);

    Integer getCountByPermission(String permission);

    Integer selectFirstLevelMenuMaxSort();

    Integer seleclMenuMaxSortByPArentId(String parentId);

    void saveOrUpdateMenu(Menu menu);
}
