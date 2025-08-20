package com.makaradev.sp4_mybatis.repository;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleRepository {
    @Select("SELECT get_article_count(#{keyword}) FROM dual")
  /*  @SelectProvider(type = ArticleProvider.class , method = "buildCountArticleSql")*/
    int countArticle(@Param("keyword")String keyword);

    @Select("SELECT * FROM TABLE(search_articles(#{keyword}))")
    List<Article> searchArticleCount(@Param("keyword")String keyword);

}
