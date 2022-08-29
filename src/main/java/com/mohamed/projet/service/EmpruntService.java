package com.mohamed.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Emprunt;
import com.mohamed.projet.repository.EmpruntRepository;

@Service
public class EmpruntService {
@Autowired
private EmpruntRepository empruntRepository;

public Page<Emprunt> getAllEmprunt(int p,int s){
	return empruntRepository.findAll(PageRequest.of(p,s));
}
public Emprunt getEmpruntById(Long id_emprunt) {
	return empruntRepository.findById(id_emprunt).orElse(null);
	
	
}	
	
public Emprunt enregistrerEmp(Emprunt emprunt) {
	
	if (emprunt.getAdherent().getId_adherent()==null)
	throw new RuntimeException( "id d'adherent n'existe pas  ");
	else if (emprunt.getDocument().getId_doc()==null)
		throw new RuntimeException( "id de document n'existe pas  ");
	else
	return empruntRepository.save(emprunt);
	
}


public void deleteEmp(Long id_emprunt) {
	empruntRepository.deleteById(id_emprunt);
	
}

public Page<Emprunt> consulterEmprunt(Adherent a,int p,int s){
	
	return empruntRepository.findByAdherent(a,PageRequest.of(p,s));
 


	
}








}
