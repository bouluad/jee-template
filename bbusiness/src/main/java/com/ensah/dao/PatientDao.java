package com.ensah.dao;

import java.util.List;

import com.boudaa.dao.GenericDao;

import com.ensah.bo.Patient;

public interface PatientDao extends GenericDao<Patient, Long> {

	public List<Patient> getPatientByName(String nom);
	
}
