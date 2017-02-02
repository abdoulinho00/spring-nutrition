package com.aelbardai.medidoc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelbardai.medidoc.beans.patient.EstheticVisit;
import com.aelbardai.medidoc.service.EstheticVisitService;

@RequestMapping("/esthetic")
@Controller
public class EstheticController {
    
    private Log logger  = LogFactory.getLog(EstheticController.class);
    @Autowired
    EstheticVisitService estheticVisitService;
    
    @RequestMapping("/add")
    public String addEditVisit(@RequestParam(value= "id" , required=false) Long id,Model model){
        EstheticVisit visit = null;
        if(id !=null && id >0){
            //call visit service
            visit = estheticVisitService.getEstheticVisitById(id) ;
        }
        if(visit ==null){
            visit = new EstheticVisit();
        }
        model.addAttribute("visit", visit);
        return "esthetic/add-edit";
    }
    
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addEditVisit(@ModelAttribute("visit") EstheticVisit visit , BindingResult result){
        
        
        /*logger.info("Size of the ssesions "+ visit.getSessions().size()); //this is the hard part
        for(EstheticSession session : visit.getSessions()){
            logger.info("observation : " + session.getObservations());
        }*/
        return "esthetic/add-edit";
    }
}
