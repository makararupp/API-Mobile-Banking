package com.makaradev.sp4_mybatis.service;

import com.makaradev.sp4_mybatis.model.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    void addNewArticle(Article article, MultipartFile file);
}
