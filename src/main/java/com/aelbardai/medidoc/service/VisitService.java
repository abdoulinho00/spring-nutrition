package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.patient.Visit;

public interface VisitService {
	
	public Visit getVisitById(long id);

	public List<Visit> getAllVisit();

	public Visit addVisit(Visit visit, long patientId);

	public Visit updateVisit(Visit visit);

	public void deleteVisit(long id);
}
