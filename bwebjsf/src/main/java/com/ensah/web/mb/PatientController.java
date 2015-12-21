package com.ensah.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;



import com.ensah.bo.Patient;
import com.ensah.services.PatientService;


public class PatientController {
	
	
	
	private Patient patient =new Patient();
	private List<Patient> patientList = new ArrayList<Patient>();
	private PatientService patientService;
	private String search;
	private List<Patient> searchList = new ArrayList<Patient>();
	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public PatientController() {
	}

	@PostConstruct
	public void populate() {
		patientList = patientService.getAllPatients();
	}
	

	public String doNew() {
		return "form.xhtml";
	}

	public String doUpdate() {
		return "update.xhtml";
	}
	
	public String doDelet() {
		return "delet.xhtml";
	}
	
	public String doDeletPatient(Patient p) {
		
		
		patientService.delet(p);
		patientList = patientService.getAllPatients();
		return "/pages/secritaire/listPatients.xhtml";
	}
	
	public String doUpdatePatient() {
		
		
		
		patientService.update(patient);
		patientList = patientService.getAllPatients();
		
		
		return "/pages/secritaire/listPatients.xhtml";
	}
	
	public String doCreatePatint() {
		patientService.addNewPatient(patient);
		patientList = patientService.getAllPatients();
		return "/pages/secritaire/listPatients.xhtml";
	}

	public String searchByNom()
	{
		
		
		
		searchList = patientService.getPatientByName(search);
		patient=searchList.get(0);
		
		
		
		return "";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public List<Patient> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Patient> searchList) {
		this.searchList = searchList;
	}
	
	
	
}
