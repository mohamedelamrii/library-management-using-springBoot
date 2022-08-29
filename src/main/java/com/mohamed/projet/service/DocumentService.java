package com.mohamed.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Document;
import com.mohamed.projet.repository.DocumentRepository;

@Service
public class DocumentService {
@Autowired
private DocumentRepository documentRepository;

public List<Document> getAllDocument(){
	
	return documentRepository.findAll();
	}

public Document getDocumentById(String id_doc){
	
	return documentRepository.findById(id_doc).orElse(null);
	}

public Document ajouterDoc(Document document) {
	
	return documentRepository.save(document);
	
}


public void deleteDoc(String id_doc) {
	documentRepository.deleteById(id_doc);
	}


public Page<Document> chercherDocParId(String id_doc,int p, int s){
	
	
	return documentRepository.chercher(id_doc, PageRequest.of(p,s));
}







	
	
	
	
	
	
	
	
}
