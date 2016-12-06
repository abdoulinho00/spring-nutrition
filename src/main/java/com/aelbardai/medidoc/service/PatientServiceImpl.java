package com.aelbardai.medidoc.service;

import java.util.List;

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
	
	/**
	 *  let you add a patient into the db
	 */
	@Override
	public Patient addPatient(Patient patient) {
		return patientDao.addPatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
		return null;
	}

	@Override
	public Patient getPatientById(long id) {
		return patientDao.getPatientById(id);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientDao.getAllPatient();
	}

	@Override
	public void deletePatient(Patient patient) {
		patientDao.deletePatient(patient);
	}

	@Override
	public void deletePatient(long patientId) {
		patientDao.deletePatient(patientId);
	}

}
