package com.aelbardai.medidoc.dao;

import java.util.List;

import com.aelbardai.medidoc.beans.patient.EstheticVisit;

public interface EstheticVisitDao {
    public EstheticVisit getEstheticVisitById(long id);

    public List<EstheticVisit> getAllEstheticVisit();

    public EstheticVisit addEstheticVisit(EstheticVisit estheticVisit);
    
    public List<EstheticVisit> getEstheticVisitByPatientId(long patientId);

    public EstheticVisit updateEstheticVisit(EstheticVisit estheticVisit);

    public void deleteEstheticVisit(EstheticVisit estheticVisit);

    public void deleteEstheticVisit(long id);
}
