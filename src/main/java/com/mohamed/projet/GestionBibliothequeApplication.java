package com.mohamed.projet;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Dictionnaire;
import com.mohamed.projet.entities.Document;
import com.mohamed.projet.entities.Emprunt;
import com.mohamed.projet.entities.Livre;
import com.mohamed.projet.entities.Revue;
import com.mohamed.projet.repository.AdherentRepository;
import com.mohamed.projet.repository.DocumentRepository;
import com.mohamed.projet.repository.EmpruntRepository;
import com.mohamed.projet.service.AdherentService;
import com.mohamed.projet.service.DocumentService;
import com.mohamed.projet.service.EmpruntService;

@SpringBootApplication
public class GestionBibliothequeApplication implements CommandLineRunner {
	@Autowired
	private AdherentService adherentService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private EmpruntService empruntService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionBibliothequeApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		  
		 
		/*
		Adherent adh1 = adherentService.ajouterAdh(new Adherent("mohamed","El amri", "knitra, lwafae", "GA218903", new Date()));
		Adherent adh2 = adherentService.ajouterAdh(new Adherent("abdo","ayouni", "knitra, irchad", "GA66666", new Date()));
		Document doc1 = documentService.ajouterDoc(new Livre("l1", 150, "mohamed safrioui", 267));
		Document doc3 = documentService.ajouterDoc(new Revue("r1", 500, new Date()));
		Document doc4 = documentService.ajouterDoc(new Dictionnaire("d1", 900,"englais"));
		Document doc2 = documentService.ajouterDoc(new Livre("l2", 200, "mohamed benani", 367));
		Emprunt emp1 = empruntService.enregistrerEmp(new Emprunt(new Date(), new Date(), adh1, doc1));
		Emprunt emp2 = empruntService.enregistrerEmp(new Emprunt(new Date(), new Date(), adh2, doc2));
		Emprunt emp3 = empruntService.enregistrerEmp(new Emprunt(new Date(), new Date(), adh1, doc3));
		Emprunt emp4 = empruntService.enregistrerEmp(new Emprunt(new Date(), new Date(), adh2, doc1));
		*/
		}

	
	
	
	
	
	
	
	
	
}
