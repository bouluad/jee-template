package com.ensah.bo;

public class Patient {

	
		private Long id;
		private String nom; 
		private String prenom; 
		
		private String PHOTO;
		private String CIN;
		private String sexe; 
		private String date_naissance; 
		private String tel_prive; 
		private String tel_bureau; 
		private String tel_mobile; 
		private String email;
		
		
		
		public Patient()
		{
			
			
		}


		
		

		public Patient(String nom, String prenom, String pHOTO, String cIN,
				String sexe, String sate_naissance, String tel_prive,
				String tel_bureau, String tel_mobile, String email) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			PHOTO = pHOTO;
			CIN = cIN;
			this.sexe = sexe;
			this.date_naissance = sate_naissance;
			this.tel_prive = tel_prive;
			this.tel_bureau = tel_bureau;
			this.tel_mobile = tel_mobile;
			this.email = email;
		}





		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getNom() {
			return nom;
		}



		public void setNom(String nom) {
			this.nom = nom;
		}



		public String getPrenom() {
			return prenom;
		}



		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}



		public String getPHOTO() {
			return PHOTO;
		}



		public void setPHOTO(String pHOTO) {
			PHOTO = pHOTO;
		}



		public String getCIN() {
			return CIN;
		}



		public void setCIN(String cIN) {
			CIN = cIN;
		}



		public String getSexe() {
			return sexe;
		}



		public void setSexe(String sexe) {
			this.sexe = sexe;
		}



		public String getDate_naissance() {
			return date_naissance;
		}



		public void setDate_naissance(String sate_naissance) {
			this.date_naissance = sate_naissance;
		}



		public String getTel_prive() {
			return tel_prive;
		}



		public void setTel_prive(String tel_prive) {
			this.tel_prive = tel_prive;
		}



		public String getTel_bureau() {
			return tel_bureau;
		}



		public void setTel_bureau(String tel_bureau) {
			this.tel_bureau = tel_bureau;
		}



		public String getTel_mobile() {
			return tel_mobile;
		}



		public void setTel_mobile(String tel_mobile) {
			this.tel_mobile = tel_mobile;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
		
	


		
		


		

		

	
	
}
