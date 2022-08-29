package com.mohamed.projet.entities;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;


@Entity
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_emprunt;
	@Column
	@NotNull
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_Emprunt;
	@Column
	@NotNull
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_retour;
	@ManyToOne
	@NotNull
	
	@JoinColumn(name = "CODE_ADH")
	private Adherent adherent;
	@ManyToOne
	@JoinColumn(name = "CODE_DOC")
	@NotNull
	
	private Document document;
	
	
	
	
	public Emprunt(Date date_Emprunt, Date date_retour, Adherent adherent, Document document) {
		super();
		this.date_Emprunt = date_Emprunt;
		this.date_retour = date_retour;
		this.adherent = adherent;
		this.document = document;
	}
	public Emprunt() {
		super();
	}
	public Long getId_emprunt() {
		return id_emprunt;
	}
	public void setId_emprunt(Long id_emprunt) {
		this.id_emprunt = id_emprunt;
	}
	public Date getDate_Emprunt() {
		return date_Emprunt;
	}
	public void setDate_Emprunt(Date date_Emprunt) {
		this.date_Emprunt = date_Emprunt;
	}
	public Date getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
