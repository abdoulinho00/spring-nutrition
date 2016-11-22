package com.aelbardai.medidoc.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.beans.patient.Visit;
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
    	Visit visit = new Visit();
    	patient.getVisits().add(visit);
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
    	patient.getVisits().get(0).setPatient(patient);
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
    	
/*    	System.out.println("from the edit patient POST meothd");
    	System.out.println("patient height : " + patient.getVisits().get(0).getStatus().getHeight());
    	System.out.println("patient visits : " + patient.getVisits().size());
    	System.out.println("patient id "+ patient.getId());
    	System.out.println("visit id "+ patient.getVisits().get(0).getId());*/
    	/*for(Visit visit : patient.getVisits()){
    		visit.setPatient(patient);
    	}*/
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
    	Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);
        return "patient/list";
    }

}
