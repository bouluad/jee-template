package com.app.business.bo;

import java.util.List;

public class Theme {
	private Long idThme;
	private String nom;
	private List<Book> livres;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Book> getLivres() {
		return livres;
	}

	public void setLivres(List<Book> livres) {
		this.livres = livres;
	}

	public Long getIdThme() {
		return idThme;
	}

	public void setIdThme(Long idThme) {
		this.idThme = idThme;
	}

}
