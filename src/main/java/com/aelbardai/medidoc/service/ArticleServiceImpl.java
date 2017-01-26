package com.aelbardai.medidoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.article.Article;
import com.aelbardai.medidoc.dao.ArticleDao;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public Article getArticleById(long id) {
		
		return articleDao.getArticleById(id);
	}

	@Override
	public List<Article> getAllArticle() {
		return articleDao.getAllArticle();
	}

	@Override
	public Article addArticle(Article article) {
		return articleDao.addArticle(article);
	}

	@Override
	public Article updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(long id) {
		articleDao.deleteArticle(id);
	}

}
