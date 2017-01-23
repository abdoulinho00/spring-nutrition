package com.aelbardai.medidoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.dao.MenuItemDao;


@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	MenuItemDao menuItemDao;
	
	@Override
	public MenuItem addMenuItem(MenuItem item) {
		menuItemDao.addMenuItem(item);
		return item;
	}
	
	@Override
	public MenuItem updateMenuItem(MenuItem item){
		menuItemDao.updateMenuItem(item);
		return item;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		if(id > 0 ){
		return menuItemDao.getMenuItem(id);
		}
		else{
			return null;
		}
	}

	@Override
	public List<MenuItem> getAllMenuItem() {
		return menuItemDao.getAllMenuItem();
	}

	@Override
	public long getMenuItemCount() {
		return menuItemDao.getMenuItemCount();
	}

	@Override
	public void deleteMenuItem(long id) {
		menuItemDao.deleteMenuItem(id);		
	}

}
