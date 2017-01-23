package com.aelbardai.medidoc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.service.MenuItemService;

@RestController
@RequestMapping("/api")
public class DietRestController {
	
	Log logger = LogFactory.getLog(DietRestController.class);
	@Autowired
	MenuItemService menuItemService;
	
	@RequestMapping(value= "/menuItem")
	@ResponseBody public MenuItem getMenuItem(@RequestParam("id") long id){
		MenuItem item = menuItemService.getMenuItem(id);
		logger.error(item.getName());
		return item;
	}
	
}
