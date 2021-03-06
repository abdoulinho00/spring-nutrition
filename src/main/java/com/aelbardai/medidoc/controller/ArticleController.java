package com.aelbardai.medidoc.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelbardai.medidoc.beans.article.Article;
import com.aelbardai.medidoc.service.ArticleService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	private final Log logger = LogFactory.getLog(ArticleController.class);
	
	@RequestMapping(value = "/health" ,method = RequestMethod.GET)
    public String listHealthArticles(ModelMap model ) {
    	System.out.println("from the add GET method");
    	List<Article> articles = articleService.getArticlesByType("HEALTH");
    	model.addAttribute("articles", articles);
        return "articles/list";
    }
	
	
   @RequestMapping(value = "/workout" ,method = RequestMethod.GET)
    public String listWorkoutArticles(ModelMap model ) {
        System.out.println("from the add GET method");
        List<Article> articles = articleService.getArticlesByType("WORKOUT");
        model.addAttribute("articles", articles);
        return "articles/list";
    }
	@RequestMapping("/view")
	public String viewArticle(@RequestParam("id") long id, Model model){
		
		Article article  = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "article/view";
	}
}
