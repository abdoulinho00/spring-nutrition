package com.aelbardai.medidoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.dao.PatientDao;


@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDao patientDao;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientDao.addPatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

}
