package com.aelbardai.medidoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model ) {
    	System.out.println("from add patient get method");
    	Patient patient = new Patient();
    	model.addAttribute("patient", patient);
        return "patient/add";
    }
 
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addPatient(  Patient patient, BindingResult result ) {
    	System.out.println("from the add method");
    	patientService.addPatient(patient);
    	return "patient/list";
    }
    @RequestMapping(value = {"/list", "/", ""}, method = RequestMethod.GET)
    public String listPatient(ModelMap model) {
    	System.out.println("from list patient get method");
        return "patient/list";
    }

}
