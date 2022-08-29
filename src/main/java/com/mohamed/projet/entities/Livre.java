package com.mohamed.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@DiscriminatorValue("LIV")
public class Livre extends Document{
	@NotBlank
	@Size(min=3,max=16)
	private String auteur;
	@NotNull
	
	private int nbrPages;
	public Livre(String id_doc, double prixDeVente, String auteur, int nbrPages) {
		super(id_doc, prixDeVente);
		this.auteur = auteur;
		this.nbrPages = nbrPages;
	}
	public Livre() {
		super();
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
