package com.aelbardai.medidoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.patient.Visit;
import com.aelbardai.medidoc.dao.VisitDao;

@Service
@Transactional
public class VisitServiceImpl implements VisitService{
	
	@Autowired
	VisitDao visitDao;
	@Autowired
	PatientService patientService;
	
	@Override
	public Visit getVisitById(long id) {
		
		return visitDao.getVisitById(id);
	}

	@Override
	public List<Visit> getAllVisit() {
		return visitDao.getAllVisit();
	}

	@Override
	public Visit addVisit(Visit visit , long patientId) {
		visit.setPatient(patientService.getPatientById(patientId));
		return visitDao.addVisit(visit);
	}

	@Override
	public Visit updateVisit(Visit visit) {
		visitDao.updateVisit(visit);
		return visit;
	}

	@Override
	public void deleteVisit(long id) {
		visitDao.deleteVisit(id);
	}

}
