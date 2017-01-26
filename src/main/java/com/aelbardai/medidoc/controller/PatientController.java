package com.aelbardai.medidoc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.beans.patient.Visit;
import com.aelbardai.medidoc.configuration.MedidocKeys;
import com.aelbardai.medidoc.service.PatientService;
import com.aelbardai.medidoc.service.VisitService;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private VisitService visitService;
	private static final Logger logger = Logger.getLogger(PatientController.class);
	
	
	
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model ) {
    	logger.warn("from the add GET method");
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
    public String addPatient(@RequestParam("file") MultipartFile file, Patient patient, BindingResult result ) {
        
        patient.getVisits().get(0).setPatient(patient);
    	
    	if(file.isEmpty()){
    	    patient = patientService.addPatient(patient);
            logger.info("empty file");
        }
        else{
            try {
                patient.setPicturePath(file.getOriginalFilename());
                patient = patientService.addPatient(patient);

                byte[] bytes = file.getBytes();
                Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patient.getId()+"/" +file.getOriginalFilename());
                Files.createDirectories(path.getParent());
                Files.write(path, bytes, StandardOpenOption.CREATE);
            } catch (IOException e) {
                //e.printStackTrace();
                logger.error("file not found : " + file.getOriginalFilename());
            }
            
        }
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
    public String editPatient(@RequestParam("file") MultipartFile file, Patient patient, BindingResult result){
        logger.info("from the edit post");
        if(file.isEmpty() || file.getOriginalFilename().equals("")){
            patient.setPicturePath(patientService.getPatientById(patient.getId()).getPicturePath());
            patientService.updatePatient(patient);
            logger.info("empty file");
        }
        else{
            try {
                patient.setPicturePath(file.getOriginalFilename());
                patientService.updatePatient(patient);

                byte[] bytes = file.getBytes();
                Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patient.getId()+"/" +file.getOriginalFilename());
                Files.createDirectories(path.getParent());
                Files.write(path, bytes, StandardOpenOption.CREATE);
            } catch (IOException e) {
                //e.printStackTrace();
                logger.error("file not found : " + file.getOriginalFilename());
            }
            
        }
    	
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
    	final Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        final LineChart chart = GCharts.newLineChart(plot);
        chart.setTitle("My Really Great Chart");
        chart.setSize(600, 480);
       
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("Batches", 50.0));
        chart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("Y axis", 100.0));
        model.addAttribute("chart",chart.toURLString());
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
    
    /*
     *  Visit controller methods
     */
    @RequestMapping("/visit/add/{id}")
    public String addVisitForm(@PathVariable("id") long id ,Model model){
    	model.addAttribute("visit", new Visit());
    	model.addAttribute("patientId", id);
    	return "patient/addVisit";
    }
    
    @RequestMapping(value="/visit/add" , method = RequestMethod.POST)
    public String addVisit(Visit visit, BindingResult result){
    	long patientId = visit.getPatient().getId();
    	logger.info("visit patient id : "+ patientId);
    	
    	visitService.addVisit(visit, patientId);
    	return "redirect:/patient/view?id="+visit.getPatient().getId();
    }
}
