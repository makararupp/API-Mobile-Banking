package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.repository.ArticleRepository;
import com.makaradev.sp4_mybatis.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    @Override
    public List<Article> findAll() {
        return articleRepository.select();
    }

    @Override
    public void addNewArticle(Article article) {
        System.out.println(article);
        articleRepository.insert(article);
    }

    
}
