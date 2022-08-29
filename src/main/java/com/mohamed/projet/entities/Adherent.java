package com.mohamed.projet.entities;



import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;



@Entity
public class Adherent  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_adherent;
	
	@Column
	@NotNull
	@Size(min=3,max=16)
	private String nom;
	
	@Column
	@NotNull
	@Size(min=3,max=16)
	private String prenom;
	
	@Column
	@NotNull
	@Size(min=3,max=16)
	private String adresse;
	@Column
	@NotNull
	@Size(min=3,max=16)
	private String cin;
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDeNaissance ;
	@OneToMany(mappedBy = "adherent")
	private Collection<Emprunt> emprunts;
	
	
	public Adherent() {
		super();
	}
	public Adherent(String nom, String prenom, String adresse, String cin, Date dateDeNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cin = cin;
		this.dateDeNaissance = dateDeNaissance;
	}
	public Long getId_adherent() {
		return id_adherent;
	}
	public void setId_adherent(Long id_adherent) {
		this.id_adherent = id_adherent;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	@Override
	public String toString() {
		return "Adherent [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cin=" + cin
				+ ", dateDeNaissance=" + dateDeNaissance + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
