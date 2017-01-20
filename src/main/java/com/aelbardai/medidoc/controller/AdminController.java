package com.aelbardai.medidoc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.diet.MenuItem;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
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
		
        return "admin/menu_maker/list";
    }
	
	@RequestMapping(value = "/menu/add" ,method = RequestMethod.GET)
    public String addEditMenu(ModelMap model ) {
		model.addAttribute("menuItem", new MenuItem());
        return "admin/menu_maker/add-edit";
    }
	@RequestMapping(value = "/menu/add" ,method = RequestMethod.POST)
	public String submitMenuForm( MenuItem menuItem, BindingResult result  ) {
		if(menuItem == null){
			logger.error("object is not initialized");
		}
		else{
			if(menuItem.getId() > 0){
				// get menu item and update it
			}
			else{
				//add new menu Item
			}
		}
		return "admin/menu_maker/add-edit";
	}
	

}
