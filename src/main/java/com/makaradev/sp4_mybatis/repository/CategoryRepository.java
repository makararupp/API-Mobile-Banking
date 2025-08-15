package com.makaradev.sp4_mybatis.repository;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryRepository{

    @InsertProvider(type = CategoryProvider.class, method = "buildInsertSql")
    void  insert(@Param("cate")Category category);
}
