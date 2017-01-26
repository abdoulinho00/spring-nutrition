package com.aelbardai.medidoc.dao;

import java.util.List;

import com.aelbardai.medidoc.beans.article.Article;

public interface ArticleDao {
	
	public Article getArticleById(long id);

	public List<Article> getAllArticle();

	public Article addArticle(Article article);

	public Article updateArticle(Article article);

	public void deleteArticle(long id);
}
