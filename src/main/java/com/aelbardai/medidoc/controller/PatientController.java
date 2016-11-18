package com.aelbardai.medidoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model ) {
    	System.out.println("from the add GET method");
    	Patient patient = new Patient();
    	model.addAttribute("patient", patient);
        return "patient/add-edit";
    }
    
    @RequestMapping(value = "/add2" ,method = RequestMethod.GET)
    public String addPatientform2(ModelMap model ) {
    	System.out.println("from the add GET method");
    	Patient patient = new Patient();
    	model.addAttribute("patient", patient);
        return "patient/add-edit2";
    }
    
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addPatient(  Patient patient, BindingResult result ) {
    	System.out.println("from the add POST method");
    	patientService.addPatient(patient);
    	return "redirect:/patient/list";
    }
    
    @RequestMapping(value="/edit", params={"id"}, method= RequestMethod.GET)
    public String editPatientForm(ModelMap model,  @RequestParam(value="id") long id){
    	
    	System.out.println("from the edit patient get method");
    	Patient patient = patientService.getPatientById(id);
    	model.addAttribute("patient", patient);
    	return "patient/add-edit";
    }
    
    @RequestMapping(value="/edit" ,  method= RequestMethod.POST)
    public String editPatient(Patient patient, BindingResult result){
    	
    	System.out.println("from the edit patient POST meothd");
    	patientService.updatePatient(patient);
    	return "redirect:/patient/";
    }
    
    @RequestMapping(value="delete" , method =RequestMethod.POST)
    public String deletePatient(@RequestParam("id") long patientId){
    	patientService.deletePatient(patientId);
    	return "redirect:/patient";
    }
    
    
    @RequestMapping(value="/view" ,method = RequestMethod.GET)
    public String viewPatient(ModelMap model ,  @RequestParam(value="id") long id){
    	Patient patient = patientService.getPatientById(id);
    	model.addAttribute("patient", patient);
    	return "patient/view";
    }
    
    @RequestMapping(value = {"/list", "/", ""}, method = RequestMethod.GET)
    public String listPatient(ModelMap model) {
    	System.out.println("from the list GET method");
    	List<Patient> patients = patientService.getAllPatient();
    	model.addAttribute("patients", patients);
        return "patient/list";
    }

}
