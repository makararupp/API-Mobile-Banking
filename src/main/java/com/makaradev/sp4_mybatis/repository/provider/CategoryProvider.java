package com.makaradev.sp4_mybatis.repository.provider;

import org.apache.ibatis.jdbc.SQL;

//Build Dynamic sql
public class CategoryProvider {

    public  String buildInsertSql(){
        return new SQL(){{
            INSERT_INTO("categories");
            VALUES("name", "#{cate.name}");
        }}.toString();
    }
}
