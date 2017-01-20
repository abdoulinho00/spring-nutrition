package com.aelbardai.medidoc.beans.diet;

public class MenuItem {
	
	private long id;
	private String name;
	//breakfast, lunch, dinner
	private String type;
	private String content;
	private String description;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getProteins() {
		return proteins;
	}
	public void setProteins(double proteins) {
		this.proteins = proteins;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	
}
