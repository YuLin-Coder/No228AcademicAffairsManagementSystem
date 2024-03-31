package com.yuanlrc.school.service;

import com.yuanlrc.school.entity.NewsinfoDB;

import java.util.List;

public interface NewsService {
    List<NewsinfoDB> findAllNews(NewsinfoDB newsinfoDB);
    int deleteNews(Integer nId);
    int addNews(NewsinfoDB newsinfoDB);
    int editNews(NewsinfoDB newsinfoDB);
}