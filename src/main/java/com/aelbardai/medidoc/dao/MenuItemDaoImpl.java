package com.aelbardai.medidoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.aelbardai.medidoc.beans.diet.MenuItem;

@Repository
public class MenuItemDaoImpl implements MenuItemDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public MenuItem addMenuItem(MenuItem item) {
		
		entityManager.persist(item);
		return item;
	}

	@Override
	public MenuItem updateMenuItem(MenuItem item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		MenuItem item  = entityManager.find(MenuItem.class, id);
		return item;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuItem> getAllMenuItem() {
		List<MenuItem> items = entityManager.createQuery("select menu from MenuItem menu order by menu.name").getResultList();
		return items;
	}

	@Override
	public long getMenuItemCount() {
		return getAllMenuItem().size();
	}

	@Override
	public void deleteMenuItem(long id) {
		entityManager.remove(getMenuItem(id));
		
	}
	
	


}
