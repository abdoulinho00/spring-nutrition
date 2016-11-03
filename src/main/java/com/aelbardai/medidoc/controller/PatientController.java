package com.aelbardai.medidoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.patient.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model) {
    	Patient patient = new Patient();
    	model.addAttribute("patient", patient);
        return "patient/add";
    }
 
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addPatient(Patient patient , ModelMap model) {
    	System.out.println("from the add method");
    	System.out.println("our patient first name is : "+ patient.getFirstname());
        return "redirect:/patient";
        //return "forward:/patient"; sends a post request to the targeted url
    }
    @RequestMapping(value = {"/list", "/", ""}, method = RequestMethod.GET)
    public String listPatient(ModelMap model) {

        return "patient/list";
    }

}
