package com.makaradev.sp4_mybatis.controller;

import com.makaradev.sp4_mybatis.model.Article;
import com.makaradev.sp4_mybatis.service.ArticleService;
import com.makaradev.sp4_mybatis.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping
    public String viewArticles(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "pages/article/article-main";
    }

    @GetMapping("/save")
    public String viewSaveArticle(Article article, Model model){
        model.addAttribute("article",article);
        model.addAttribute("categories",categoryService.findAll());
        return "pages/article/article-save";
    }

    @PostMapping("/save")
    public String saveArticle(@Valid Article article, BindingResult result,
     Model model, @RequestParam("thumbnailFile")MultipartFile file){
      if(result.hasErrors() || file.isEmpty()){
          System.out.println(article);
          if(file.isEmpty()){
              model.addAttribute("isFileEmpty",true);
          }
          return viewSaveArticle(article,model);
      }
      System.out.println(file.getOriginalFilename());
        return "redirect:/article";
    }
}
