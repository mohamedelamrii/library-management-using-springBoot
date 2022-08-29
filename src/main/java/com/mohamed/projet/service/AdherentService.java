package com.mohamed.projet.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mohamed.projet.entities.Adherent;

import com.mohamed.projet.repository.AdherentRepository;
@Service
public class AdherentService {
	@Autowired
	private AdherentRepository adherentRepository;
	

	
	public Page<Adherent> getAllAdherent(int p,int s){
		return adherentRepository.findAll(PageRequest.of(p,s));
		}
	public Adherent getAdherentById(Long id_adherent) {
		
		return adherentRepository.findById(id_adherent).orElse(null);
	}
	
	public Adherent ajouterAdh(Adherent adherent) {
		Adherent adh = adherentRepository.save(adherent);
		return adh;
		
		}
	
	public void deleteAdh( Long id_adherent ) {
		adherentRepository.deleteById(id_adherent);
		} 
	
	public Page<Adherent> chercherAdhParCIN(String cin,int p, int s){
		
		
		return adherentRepository.chercher(cin, PageRequest.of(p,s));
	}
	
	
	
	

}
