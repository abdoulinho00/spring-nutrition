package com.aelbardai.medidoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/diet")
public class DietController {

	
	@RequestMapping(value = "/calorycount" ,method = RequestMethod.GET)
    public String caloryCount(ModelMap model ) {
		
        return "diet/calory_count";
    }
	
	
	@RequestMapping(value = "/menumaker" ,method = RequestMethod.GET)
	public String menuMaker(ModelMap model ) {
		
		return "diet/menu_maker";
	}
}
