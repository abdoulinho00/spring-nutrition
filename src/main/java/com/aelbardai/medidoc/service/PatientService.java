package com.aelbardai.medidoc.service;

import java.util.List;

import com.aelbardai.medidoc.beans.patient.Patient;

public interface PatientService {
	public Patient getPatientById(long id);

	public List<Patient> getAllPatient();

	public Patient addPatient(Patient patient);

	public Patient updatePatient(Patient patient);

	public void deletePatient(Patient patient);

	public void deletePatient(long patientId);
}
