package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public List<Article> findAll() {
        return null;
    }
}
