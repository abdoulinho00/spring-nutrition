package com.aelbardai.medidoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.article.Article;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@RequestMapping(value = "/health" ,method = RequestMethod.GET)
    public String listHealthArticles(ModelMap model ) {
    	System.out.println("from the add GET method");
    	List<Article> articles = new ArrayList<Article>(); // get it from the service layer once it is implemented
    	Article article = new Article();
    	article.setAuthor("abderrahmane");
    	article.setContent("some content");
    	article.setTitle("6 myths about dairy products");
    	articles.add(article);
    	model.addAttribute("articles", articles);
        return "articles/list";
    }
}