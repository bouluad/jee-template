package com.ensah.dao;

import java.util.List;

import com.boudaa.dao.impl.GenericDaoImpl;
import com.ensah.bo.Patient;


public class PatientDaoImp  extends GenericDaoImpl<Patient, Long> implements PatientDao {
	public PatientDaoImp() {
		super(Patient.class);
	}

	@Override
	public List<Patient> getPatientByName(String n) {
		
		 return getHibernateTemplate().find(
				"from Patient where soundex(nom)=soundex(?)",n);
		 
		 
		
	}
}
