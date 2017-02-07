package com.aelbardai.medidoc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.beans.patient.Visit;
import com.aelbardai.medidoc.configuration.MedidocKeys;
import com.aelbardai.medidoc.service.MenuItemService;
import com.aelbardai.medidoc.service.VisitService;

@RestController
@RequestMapping("/api")
public class DietRestController {

    Log logger = LogFactory.getLog(DietRestController.class);
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    VisitService visitService;

    @RequestMapping(value = "/menuItem")
    @ResponseBody
    public MenuItem getMenuItem(@RequestParam("id") long id) {
        MenuItem item;
        try {
            item = menuItemService.getMenuItem(id);
        } catch (Exception e) {
            logger.error("entry not found");
            item = new MenuItem();
        }

        return item;
    }

    @RequestMapping("/getchartdata/{id}")
    public List<Object[]> getChartData(@PathVariable("id") long id) {
        List<Object[]> data = new ArrayList<>();
        Object[] object = { "Date", "Weight" , "lean mass" , "fat mass" };
        data.add(object);
        List<Visit> visits = visitService.getVisitByPatientId(id);
        for (int i = visits.size() - 1; i >= 0; i--) {
            Visit v = visits.get(i);
            if (v.getVisitTime() != null && v.getWeight() > 0) {
                Object[] obj = new Object[object.length];
                obj[0] = v.getVisitTime();
                obj[1] = v.getWeight();
                obj[2] = v.getLeanMass();
                obj[3] = v.getFatMass();
                data.add(obj);
            }
        }
        return data;
    }

    @RequestMapping(value = "/getImage/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable("id") long id, @RequestParam("imageId") String imageId,
            HttpServletRequest request) {
        // String rpath=request.getRealPath("/home/aelbardai/data");
        String rpath = MedidocKeys.UPLOADED_FOLDER;
        rpath = rpath + "/" + id + "/" + imageId; // whatever path you used for storing the file
        Path path = Paths.get(rpath);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("file not found : " + id + "/" + imageId);
        }
        return data;
    }

    @RequestMapping(value = "/getImage/{patientId}/nutrition/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable("id") long id, @PathVariable("patientId") long patientId, @RequestParam("imageId") String imageId,
            HttpServletRequest request) {
        // String rpath=request.getRealPath("/home/aelbardai/data");
        String rpath = MedidocKeys.UPLOADED_FOLDER;
        rpath = rpath + "/" + patientId+"/nutrition/" + id + "/" + imageId; // whatever path you used for storing the file
        Path path = Paths.get(rpath);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("file not found : " + id + "/" + imageId);
        }
        return data;
    }
    
    @RequestMapping(value = "/getImage/{patientId}/esthetic/{id}/{sessionId}")
    @ResponseBody
    public byte[] getEstheticImage(@PathVariable("sessionId") long sessionId , @PathVariable("id") long id, @PathVariable("patientId") long patientId, @RequestParam("imageId") String imageId,
            HttpServletRequest request) {
        // String rpath=request.getRealPath("/home/aelbardai/data");
        String rpath = MedidocKeys.UPLOADED_FOLDER;
        rpath = rpath + "/" + patientId+"/esthetic/" + id + "/"+sessionId +"/" + imageId; // whatever path you used for storing the file
        Path path = Paths.get(rpath);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("file not found : " + rpath);
        }
        return data;
    }

}
