package com.aelbardai.medidoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.aelbardai.medidoc.beans.article.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Article getArticleById(long id) {
		return entityManager.find(Article.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticle() {
		return entityManager.createQuery("select article from Article article order by article.modifiedAt desc ").getResultList();
	}

	@Override
	public Article addArticle(Article article) {
		entityManager.persist(article);
		return article;
	}

	@Override
	public Article updateArticle(Article article) {
		entityManager.merge(article);
		return article;
	}

	@Override
	public void deleteArticle(long id) {
		entityManager.remove(getArticleById(id));
	}

}
