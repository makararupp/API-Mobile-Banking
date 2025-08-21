package com.makaradev.sp4_mybatis;

import com.makaradev.sp4_mybatis.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sp4MybatisApplicationTests {
	@Autowired
	//filed injection
   private ArticleRepository articleRepository;

	@Test
	void testSelectArticle(){
		System.out.println(articleRepository.select());
	}
	@Test
	void testCountArticleByKeyword(){
		//TODO:
		System.out.println("The result article Test counter:"+articleRepository.countArticle("java"));
	}
	@Test
	void testSearchArticleCount(){
		//TODO:
		System.out.println(articleRepository.searchArticleCount("spring"));
	}

}
