package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.article.Article;

public interface ArticleService {
	
	public Article getArticleById(long id);

	public List<Article> getAllArticle();
	
	public List<Article> getArticlesByType(String type);

	public Article addArticle(Article article);

	public Article updateArticle(Article article);

	public void deleteArticle(long id);
}
