package com.ensah.services;

import java.util.List;

import com.ensah.bo.Patient;



public interface PatientService {

	public void addNewPatient(Patient p);
	public void update(Patient p);
	public void delet(Patient p);
	public List<Patient> getAllPatients();

	public List<Patient> getPatientByName(String nom);

	
}
