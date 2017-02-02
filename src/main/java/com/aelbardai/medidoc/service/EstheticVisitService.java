package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.patient.EstheticVisit;

public interface EstheticVisitService {
    public EstheticVisit getEstheticVisitById(long id);

    public List<EstheticVisit> getAllEstheticVisit();

    public EstheticVisit addEstheticVisit(EstheticVisit estheticVisit, long patientId);

    public EstheticVisit updateEstheticVisit(EstheticVisit estheticVisit);
    
    public List<EstheticVisit> getEstheticVisitByPatientId(long patientId);

    public void deleteEstheticVisit(EstheticVisit estheticVisit);

    public void deleteEstheticVisit(long id);
}
