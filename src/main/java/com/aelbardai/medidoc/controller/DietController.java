package com.aelbardai.medidoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.beans.diet.MenuType;
import com.aelbardai.medidoc.service.MenuItemService;

@Controller
@RequestMapping("/diet")
public class DietController {

	@Autowired
	MenuItemService menuItemService;
	
	@RequestMapping(value = "/calorycount" ,method = RequestMethod.GET)
    public String caloryCount(ModelMap model ) {
		
        return "diet/calory_count";
    }
	
	
	@RequestMapping(value = "/menumaker" ,method = RequestMethod.GET)
	public String menuMaker(ModelMap model ) {
		List<MenuItem> menuItems = menuItemService.getAllMenuItem();
		model.addAttribute("menuItems", menuItems);
		model.addAttribute("menuTypes",MenuType.values());
		
		return "diet/menu_maker";
	}
	
}
