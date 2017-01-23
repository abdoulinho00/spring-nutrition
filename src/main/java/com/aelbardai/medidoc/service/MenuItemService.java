package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.diet.MenuItem;

public interface MenuItemService {
	
	public MenuItem addMenuItem(MenuItem item);
	
	public MenuItem updateMenuItem(MenuItem item);
	
	public MenuItem getMenuItem(long id);
	
	public List<MenuItem> getAllMenuItem();
	
	public long getMenuItemCount();
	
	public void deleteMenuItem(long id);
}
