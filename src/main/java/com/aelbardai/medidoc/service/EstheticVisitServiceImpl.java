package com.aelbardai.medidoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.patient.EstheticVisit;
import com.aelbardai.medidoc.dao.EstheticVisitDao;

@Service
@Transactional
public class EstheticVisitServiceImpl implements EstheticVisitService{
    
    @Autowired
    EstheticVisitDao estheticVisitDao;
    @Autowired
    PatientService patientService;
    
    @Override
    public EstheticVisit getEstheticVisitById(long id) {
        return estheticVisitDao.getEstheticVisitById(id);
    }

    @Override
    public List<EstheticVisit> getAllEstheticVisit() {
        return estheticVisitDao.getAllEstheticVisit();
    }

    @Override
    public EstheticVisit addEstheticVisit(EstheticVisit estheticVisit, long patientId) {
        estheticVisit.setPatient(patientService.getPatientById(patientId));

        return estheticVisitDao.addEstheticVisit(estheticVisit);
    }

    @Override
    public EstheticVisit updateEstheticVisit(EstheticVisit estheticVisit) {
        return estheticVisitDao.updateEstheticVisit(estheticVisit);
    }

    @Override
    public void deleteEstheticVisit(EstheticVisit estheticVisit) {
        estheticVisitDao.deleteEstheticVisit(estheticVisit);
        
    }

    @Override
    public void deleteEstheticVisit(long id) {
        estheticVisitDao.deleteEstheticVisit(id);
        
    }

    @Override
    public List<EstheticVisit> getEstheticVisitByPatientId(long patientId) {
        List<EstheticVisit> visits = estheticVisitDao.getEstheticVisitByPatientId(patientId);
        if(visits == null){
            visits= new ArrayList<EstheticVisit>();
        }
        return visits;
    }

}
