package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.model.FileUpload;
import com.makaradev.sp4_mybatis.repository.ArticleRepository;
import com.makaradev.sp4_mybatis.service.ArticleService;
import com.makaradev.sp4_mybatis.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final FileService fileService;
    @Override
    public List<Article> findAll() {
        return articleRepository.select();
    }

    @Override
    public void addNewArticle(Article article, MultipartFile file) {
        // business logic upload file...
        FileUpload fileUpload = fileService.uploadFile(file);

        if (fileUpload.isUploaded()) {
            try {
                article.setThumbnail(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            article.setStatus(true);
            articleRepository.insert(article);
        }
    }

}
