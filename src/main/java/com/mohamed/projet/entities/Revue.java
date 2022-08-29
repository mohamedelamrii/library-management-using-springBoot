package com.mohamed.projet.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@DiscriminatorValue("REV")
public class Revue extends Document {
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	
	private Date anneeDePub;

	public Date getAnneeDePub() {
		return anneeDePub;
	}

	public void setAnneeDePub(Date anneeDePub) {
		this.anneeDePub = anneeDePub;
	}

	public Revue(String id_doc, double prixDeVente, Date anneeDePub) {
		super(id_doc, prixDeVente);
		this.anneeDePub = anneeDePub;
	}

	public Revue() {
		super();
	}
	
	
	

}
