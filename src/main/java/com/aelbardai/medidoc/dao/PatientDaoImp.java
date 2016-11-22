package com.aelbardai.medidoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.aelbardai.medidoc.beans.patient.Patient;
import com.aelbardai.medidoc.beans.patient.Visit;

@Repository
public class PatientDaoImp implements PatientDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Patient getPatientById(long id) {
		return entityManager.find(Patient.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatient() {
		return entityManager.createQuery("select p from Patient p ").getResultList();

	}

	@Override
	public Patient addPatient(Patient patient) {
		entityManager.persist(patient);
		return patient;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		for(Visit visit : patient.getVisits()){
			visit.setPatient(patient);
			visit.getStatus().setVisit(visit);
		}
		entityManager.merge(patient);
		return patient;
	}

	@Override
	public void deletePatient(Patient patient) {
		entityManager.remove(patient);

	}

	@Override
	public void deletePatient(long patientId) {
		deletePatient(getPatientById(patientId));

	}

}
