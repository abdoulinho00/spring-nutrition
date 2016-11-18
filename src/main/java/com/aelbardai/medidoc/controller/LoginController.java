package com.aelbardai.medidoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.User;

@Controller
@RequestMapping("/profile")
public class LoginController {

	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model ) {
    	System.out.println("from the add GET method");
    	User user = new User();
    	model.addAttribute("user", user);
        return "profile/add";
    }
}
