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
    public String buildSelectSql(){
        return  new SQL(){{
            SELECT("ID, Name");
            FROM("categories");
            ORDER_BY("id ASC");
        }}.toString();
    }

    public String  buildDeleteSql(){
        return  new SQL(){{
            DELETE_FROM("categories");
            WHERE("id = #{id}");
        }}.toString();
    }
}
