package com.makaradev.sp4_mybatis.repository;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleRepository {
    @SelectProvider(type = ArticleProvider.class, method = "buildSelectSql")
    @Results(id = "articleResultMap",value = {
            @Result(column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "status", property = "status"),
            @Result(column = "cate_id",property = "category" ,
                    one = @One(select = "selectArticleCategory"))
    })
    List<Article> select();

    @SelectProvider(type = ArticleProvider.class, method = "buildSelectArticleCategorySql")
    Category selectArticleCategory(@Param("cate_id") Integer cateId);

    @Select("SELECT get_article_count(#{keyword}) FROM dual")
  /*  @SelectProvider(type = ArticleProvider.class , method = "buildCountArticleSql")*/
    int countArticle(@Param("keyword")String keyword);

    @Select("SELECT * FROM TABLE(search_articles(#{keyword}))")
    List<Article> searchArticleCount(@Param("keyword")String keyword);

}
