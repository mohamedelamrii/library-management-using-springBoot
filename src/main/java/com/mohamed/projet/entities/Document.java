package com.mohamed.projet.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DOC",discriminatorType = DiscriminatorType.STRING,length = 3)
public abstract class Document {
	@Id
	@Column
	@NotBlank
	private  String id_doc;
	@Column
	@NotNull
	
	private double prixDeVente;
	@OneToMany(mappedBy = "document")
	private Collection<Emprunt> emprunts;
	public Document(String id_doc, double prixDeVente) {
		super();
		this.id_doc = id_doc;
		this.prixDeVente = prixDeVente;
	}
	public Document() {
		super();
	}
	public String getId_doc() {
		return id_doc;
	}
	public void setId_doc(String id_doc) {
		this.id_doc = id_doc;
	}
	public double getPrixDeVente() {
		return prixDeVente;
	}
	public void setPrixDeVente(double prixDeVente) {
		this.prixDeVente = prixDeVente;
	}
	
	
	
	
	

}
