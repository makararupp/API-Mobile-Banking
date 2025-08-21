package com.makaradev.sp4_mybatis.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String buildSelectArticleCategorySql(){
        return new SQL(){{
            SELECT("*");
            FROM("categories");
            WHERE("id =#{cate_id}");
        }}.toString();
    }
    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM("articles");
        }}.toString();
    }

    public String buildCountArticleSql(){
        return  new SQL(){{
             SELECT("get_article_count(#{keyword})");
             FROM("from dual");
        }}.toString();
    }
}
