package com.mohamed.projet.entities;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@DiscriminatorValue("DIC")
public class Dictionnaire extends Document{
	@NotNull
	@Size(min=3,max=7)
private String langue;

public Dictionnaire(String id_doc, double prixDeVente, String langue) {
	super(id_doc, prixDeVente);
	this.langue = langue;
}

public Dictionnaire() {
	super();
}

public String getLangue() {
	return langue;
}

public void setLangue(String langue) {
	this.langue = langue;
}










}
