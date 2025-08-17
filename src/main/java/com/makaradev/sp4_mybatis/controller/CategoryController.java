package com.makaradev.sp4_mybatis.controller;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public  String viewCategory(Category category, Model model){
        model.addAttribute("category", category);
        model.addAttribute("categories",categoryService.findAll());
        return  "pages/category/cate-main";
    }

    @PostMapping("/save")
    public String  saveCategory(@Valid  Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            //check condition errors will be return the form user back to the form page cate-main.Nca
            //return "pages/category/cate-main";
            return viewCategory(category, model);
        }
        log.info("Category saved :"+category);
        if(category.getId() == null){
            categoryService.AddNewCategory(category);
        }else{
            categoryService.updateCategoryId(category.getId(), category);
        }
        return "redirect:/category"; // redirect to listing page.
    }

    @GetMapping("/{id}/delete")
    public String deleteCategoryById(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String updateCategoryById(@PathVariable("id") Long id, Model model){
        Category updateNewCate = categoryService.findById(id);
        return viewCategory(updateNewCate, model);
    }

}
