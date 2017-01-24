package com.aelbardai.medidoc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.service.MenuItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	MenuItemService menuItemService;
	
	@RequestMapping(value = "" ,method = RequestMethod.GET)
    public String adminControlPanel(ModelMap model ) {
		
        return "admin/view";
    }
	/*
	 * 	Methods of menu items management
	 */
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/menu" ,method = RequestMethod.GET)
    public String listMenu(ModelMap model ) {
		List<MenuItem> menuItems = menuItemService.getAllMenuItem();
		model.addAttribute("menuItems", menuItems);
        return "admin/menu_maker/list";
    }
	
	
	@RequestMapping(value = "/menu/add" ,method = RequestMethod.GET)
    public String addEditMenu(@RequestParam(value = "id" ,required =false) Long id , ModelMap model ) {
		MenuItem menuItem;
		if(id != null && id > 0){
			menuItem = menuItemService.getMenuItem(id);
			if(menuItem == null){
				menuItem = new MenuItem();
			}
		}
		else{
			menuItem = new MenuItem();
		}
		model.addAttribute("menuItem",menuItem);
        return "admin/menu_maker/add-edit";
    }
	
	@RequestMapping(value = "/menu/add" ,method = RequestMethod.POST)
	public String submitMenuForm( MenuItem menuItem, BindingResult result  ) {
		if(menuItem == null){
			logger.error("object is not initialized");
		}
		else{
			if(menuItem.getId() > 0){
				menuItemService.updateMenuItem(menuItem);
			}
			else{
				menuItemService.addMenuItem(menuItem);
			}
		}
		return "redirect:/admin/menu";
	}
	
	@RequestMapping("/menu/remove")
	public String removeMenuItem(@RequestParam("id") long id){
		menuItemService.deleteMenuItem(id);
		return "redirect:/admin/menu";
	}
	

}
