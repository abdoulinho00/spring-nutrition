package com.aelbardai.medidoc.dao;

import java.util.List;

import com.aelbardai.medidoc.beans.patient.Visit;

public interface VisitDao {
	
	public Visit getVisitById(long id);

	public List<Visit> getAllVisit();
	
	public List<Visit> getVisitByPatientId(long patientId);

	public Visit addVisit(Visit visit);

	public Visit updateVisit(Visit visit);

	public void deleteVisit(long id);
}
