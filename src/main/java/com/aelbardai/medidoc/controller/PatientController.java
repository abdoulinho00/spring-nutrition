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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aelbardai.medidoc.beans.patient.EstheticVisit;
import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.beans.patient.Visit;
import com.aelbardai.medidoc.configuration.MedidocKeys;
import com.aelbardai.medidoc.service.EstheticVisitService;
import com.aelbardai.medidoc.service.PatientService;
import com.aelbardai.medidoc.service.VisitService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private VisitService visitService;
	@Autowired
    private EstheticVisitService estheticVisitService;
	private static final Logger logger = Logger.getLogger(PatientController.class);
	
	
	
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addPatientform(ModelMap model ) {
    	logger.warn("from the add GET method");
    	Patient patient = new Patient();
    	/*Visit visit = new Visit();
    	patient.getVisits().add(visit);*/
    	model.addAttribute("patient", patient);
    	
        return "patient/add-edit";
    }
    
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addPatient(@RequestParam("file") MultipartFile file, Patient patient, BindingResult result ) {
        
        //patient.getVisits().get(0).setPatient(patient);
    	
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
    	patient.setVisits(visitService.getVisitByPatientId(id));
    	patient.setEstheticVisits(estheticVisitService.getEstheticVisitByPatientId(id));
    	model.addAttribute("patient", patient);
    	logger.info("esthetic visits  :" + patient.getEstheticVisits().size());
    	logger.info(" visits  :" + estheticVisitService.getAllEstheticVisit());
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
     *  nutrition Visit controller methods
     */
    @RequestMapping("/nutrition/visit/add/{id}")
    public String addVisitForm(@RequestParam(value ="visitId" , required = false) Long visitId, @PathVariable("id") long id ,Model model){
    	Visit visit =null ;
        if(visitId != null && visitId >0){
            visit = visitService.getVisitById(visitId);
        }
        if(visit ==null){
            visit = new Visit();
        }
        model.addAttribute("visit", visit);
    	model.addAttribute("patientId", id);
    	return "patient/addVisit";
    }
    
    @RequestMapping(value="/nutrition/visit/add" , method = RequestMethod.POST)
    public String addVisit(@RequestParam("beforefile") MultipartFile beforeFile ,@RequestParam("afterfile") MultipartFile afterFile,Visit visit, BindingResult result){
    	long patientId = visit.getPatient().getId();
    	
    	boolean isBeforeFile = !beforeFile.isEmpty() && !beforeFile.getOriginalFilename().equals("");
    	boolean isAfterFile = !afterFile.isEmpty() && !afterFile.getOriginalFilename().equals("");
    	if(isBeforeFile){
    	    visit.setBeforePath(beforeFile.getOriginalFilename());
    	}
    	if(isAfterFile){
    	    visit.setAfterPath(afterFile.getOriginalFilename());
    	}
    	
    	
    	if(visit.getId()<=0){
    	visit = visitService.addVisit(visit, patientId);
    	}
    	else{
    	    logger.info("updating user" + visit.getId());
    	    visit = visitService.updateVisit(visit);
    	}
    	
    	if(isBeforeFile){
    	    byte[] bytes;
            try {
                bytes = beforeFile.getBytes();
            
            Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patientId+"/nutrition/" +visit.getId()+"/"  +beforeFile.getOriginalFilename());
            Files.createDirectories(path.getParent());
            Files.write(path, bytes, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    	if(isAfterFile){
    	    byte[] bytes;
            try {
                bytes = afterFile.getBytes();
            
            Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patientId+"/nutrition/" +visit.getId()+"/"  +afterFile.getOriginalFilename());
            Files.createDirectories(path.getParent());
            Files.write(path, bytes, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    	
    	return "redirect:/patient/view?id="+visit.getPatient().getId();
    }
    
    @RequestMapping(value="/nutrition/visit/view/{id}")
    public String viewVisit(@PathVariable("id") long id , Model model){
        
        Visit visit = visitService.getVisitById(id);
        model.addAttribute("visit" , visit);
        return "patient/viewVisit";
    }
    
    /*
     * Esthetic visit controller methods
     */
    
    @RequestMapping("/esthetic/visit/add/{patientId}")
    public String addEditVisit(@RequestParam(value= "visitId" , required=false) Long id, @PathVariable long patientId, Model model){
        EstheticVisit visit = null;
        if(id !=null && id >0){
            //call visit service
            visit = estheticVisitService.getEstheticVisitById(id) ;
            logger.info("patient id "  + visit.getPatient().getId());
        }
        if(visit ==null){
            visit = new EstheticVisit();
        }
        model.addAttribute("patientId" , patientId);
        model.addAttribute("visit", visit);
        return "esthetic/add-edit";
    }
    
    @RequestMapping(value = "/esthetic/visit/add" , method = RequestMethod.POST)
    public String addEditVisit(@RequestParam("facefile") MultipartFile[] faceFiles ,@RequestParam("rightfile") MultipartFile[] rightFiles ,@RequestParam("leftfile") MultipartFile[] leftFiles ,@ModelAttribute("visit") EstheticVisit visit , BindingResult result){
        long patientId = visit.getPatient().getId();
        boolean[] isFaceFile = new boolean[faceFiles.length];
        boolean[] isRightFile = new boolean[leftFiles.length];
        boolean[] isLeftFile = new boolean[rightFiles.length];
        if(visit.getId() > 0){
            visit.setSessions(estheticVisitService.getEstheticVisitById(visit.getId()).getSessions());
        }
        for(int i=0;i<faceFiles.length;i++){
            isFaceFile[i] = !faceFiles[i].isEmpty() && !faceFiles[i].getOriginalFilename().equals("");
            if(isFaceFile[i]){
                visit.getSessions().get(i).setFacePath(faceFiles[i].getOriginalFilename());
            }
            isRightFile[i] = !rightFiles[i].isEmpty() && !rightFiles[i].getOriginalFilename().equals("");
            if(isRightFile[i]){
                visit.getSessions().get(i).setRightProfilePath(rightFiles[i].getOriginalFilename());
            }
            isLeftFile[i] = !leftFiles[i].isEmpty() && !leftFiles[i].getOriginalFilename().equals("");
            if(isLeftFile[i]){
                visit.getSessions().get(i).setLeftProfilePath(leftFiles[i].getOriginalFilename());
            }
        }
        if(visit.getId() <= 0){
            visit = estheticVisitService.addEstheticVisit(visit , patientId);
            //visit  = estheticVisitService.getEstheticVisitById(visit.getId());
        }
        else{
           visit = estheticVisitService.updateEstheticVisit(visit);
        }
        
        for(int i=0;i<faceFiles.length;i++){
            logger.info("id de la session : " + visit.getSessions().get(i).getId());
            if(isRightFile[i]){
                byte[] bytes;
                try {
                    bytes = rightFiles[i].getBytes();
                
                Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patientId+"/esthetic/" +visit.getId()+"/" +visit.getSessions().get(i).getId()+"/" +rightFiles[i].getOriginalFilename());
                Files.createDirectories(path.getParent());
                Files.write(path, bytes, StandardOpenOption.CREATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isFaceFile[i]){
                byte[] bytes;
                try {
                    bytes = faceFiles[i].getBytes();
                    
                    Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patientId+"/esthetic/" +visit.getId()+"/"+visit.getSessions().get(i).getId()+"/"  +faceFiles[i].getOriginalFilename());
                    Files.createDirectories(path.getParent());
                    Files.write(path, bytes, StandardOpenOption.CREATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isLeftFile[i]){
                byte[] bytes;
                try {
                    bytes = leftFiles[i].getBytes();
                    
                    Path path = Paths.get(MedidocKeys.UPLOADED_FOLDER + patientId+"/esthetic/" +visit.getId()+"/" +visit.getSessions().get(i).getId()+"/" +leftFiles[i].getOriginalFilename());
                    Files.createDirectories(path.getParent());
                    Files.write(path, bytes, StandardOpenOption.CREATE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/patient/view?id="+visit.getPatient().getId();
    }
    
    @RequestMapping(value="/esthetic/visit/view/{id}")
    public String viewEstheticVisit(@PathVariable("id") long id , Model model){
        
        EstheticVisit visit = estheticVisitService.getEstheticVisitById(id);
        model.addAttribute("visit", visit);
        return "esthetic/viewVisit";
    }
}
