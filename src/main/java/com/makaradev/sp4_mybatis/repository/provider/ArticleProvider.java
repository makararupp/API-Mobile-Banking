package com.makaradev.sp4_mybatis.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String buildCountArticleSql(){
        return  new SQL(){{
             SELECT("get_article_count(#{keyword})");
             FROM("from dual");
        }}.toString();
    }
}
