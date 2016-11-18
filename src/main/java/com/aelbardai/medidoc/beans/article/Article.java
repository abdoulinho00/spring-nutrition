package com.aelbardai.medidoc.beans.article;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6333546188980805846L;
	private long id;
	private String title;
	private String content;
	private String tags;
	private String author;
	private Date writtenAt;
	private Date modifiedAt;
	private ArticleType type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getWrittenAt() {
		return writtenAt;
	}
	public void setWrittenAt(Date writtenAt) {
		this.writtenAt = writtenAt;
	}
	public ArticleType getType() {
		return type;
	}
	public void setType(ArticleType type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
	
	
}
