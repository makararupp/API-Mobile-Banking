package com.makaradev.sp4_mybatis.repository;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository{

    @InsertProvider(type = CategoryProvider.class, method = "buildInsertSql")
    void  insert(@Param("cate")Category category);

    @SelectProvider(type = CategoryProvider.class, method = "buildSelectSql")
    List<Category> select();

    @DeleteProvider(type = CategoryProvider.class , method = "buildDeleteSql")
    void deleteById(@Param("id") Long id);
}
