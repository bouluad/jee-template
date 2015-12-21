package com.ensah.services;

import java.util.ArrayList;
import java.util.List;

import com.ensah.bo.Patient;
import com.ensah.dao.PatientDao;

public class PatientServiceImpl implements PatientService {
	
	private PatientDao patientDao;

	@Override
	public void addNewPatient(Patient p) {
		
		patientDao.create(p);
		
	}

	@Override
	public void update(Patient p) {
		
		patientDao.update(p);
		
	}

	@Override
	public void delet(Patient p) {
		
		patientDao.delete(p.getId());
		
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return patientDao.getAll();
	}

	@Override
	public List<Patient> getPatientByName(String nom) {
		
/*	List<Patient> patientList = new ArrayList<Patient>();
	List<Patient> pl = new ArrayList<Patient>();
	patientList=patientDao.getAll();
	
	for (Patient patient : patientList) {
		
		if(patient.getNom().equals(nom))
		{		
			
			pl.add(patient);
		}
	}
	
	
	
		return pl;*/
		return patientDao.getPatientByName(nom);
	}

	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	
	
}
