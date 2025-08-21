package com.makaradev.sp4_mybatis.service;

import com.makaradev.sp4_mybatis.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
}
