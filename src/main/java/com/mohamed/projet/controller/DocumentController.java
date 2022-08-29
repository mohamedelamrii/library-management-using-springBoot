package com.mohamed.projet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Dictionnaire;
import com.mohamed.projet.entities.Document;
import com.mohamed.projet.entities.Livre;
import com.mohamed.projet.entities.Revue;
import com.mohamed.projet.service.DocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
private DocumentService documentService;
	@GetMapping("lister")
	public String listerDoc(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s,
            @RequestParam(name = "idCherch", defaultValue = "") String idCherch) {
		
		
	Page<Document> documents = documentService.chercherDocParId("%"+idCherch+"%", p, s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("idCherch", idCherch);
		
		return "Document/index";
	}
	
	@GetMapping("edit")
	public String edit(Model model,String id_doc,String type) {
		Document document = documentService.getDocumentById(id_doc);
		model.addAttribute("document", document);
		if (type.equals("Livre"))
		return "Document/modifierLiv";
		else if( type.equals("Revue"))
			return "Document/modifierRev";
		else
			return "Document/modifierDic";
	}
	
	
	
	
	
	
	@GetMapping("delete")
	public String deleteDoc(Model model,String id_doc,int page,int size,String idCherch) {
		documentService.deleteDoc(id_doc);
		
		return "redirect:/document/lister?page="+page+"&size="+size+"&idCherch="+idCherch;
	}
	
	
	
	
	
	@GetMapping("ajouterLiv")
	public String formLiv(Model model) {
		model.addAttribute("document", new Livre());
		return "Document/ajouterLiv";
	}
	@GetMapping("editLiv")
	public String editLiv(Model model,String id_doc) {
		Document document = documentService.getDocumentById(id_doc);
		model.addAttribute("document", document);
		return "Document/modifierLiv";
	}

@PostMapping("saveLiv")
public String saveLiv(@Valid Livre document ,BindingResult bindingResult){
	
	if (bindingResult.hasErrors())
		return "Document/ajouterLiv";
	
 
	documentService.ajouterDoc(document);
	
	
	return "redirect:/document/listerLiv";
}
@GetMapping("deleteLiv")
public String deleteLiv(Model model,String id_doc,int page,int size,String idCherch) {
	documentService.deleteDoc(id_doc);
	
	return "redirect:/document/listerLiv?page="+page+"&size="+size+"&idCherch="+idCherch;
}
	
	@GetMapping("listerLiv")
	public String listerLiv(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s,
            @RequestParam(name = "idCherch", defaultValue = "") String idCherch) {
		
		
	Page<Document> documents = documentService.chercherDocParId("%"+idCherch+"%", p, s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("idCherch", idCherch);
		
		return "Document/afficherLivres";
	}
	
	@GetMapping("ajouterRev")
	public String formRev(Model model) {
		model.addAttribute("document", new Revue());
		return "Document/ajouterRev";
	}
	@PostMapping("saveRev")
	public String saveRev( @Valid Revue document,
			@RequestParam(name = "anneeDePub", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
			,BindingResult bindingResult){
		
		if (bindingResult.hasErrors())
			return "Document/ajouterRev";
	    
		documentService.ajouterDoc(document);
		
		
		return "redirect:/document/listerRev";
	}
	
	@GetMapping("listerRev")
	public String listerRev(Model model, @RequestParam(name = "page", defaultValue = "1") int p,
            @RequestParam(name = "size", defaultValue = "6") int s,
            @RequestParam(name = "idCherch", defaultValue = "") String idCherch) {
		
		
	Page<Document> documents = documentService.chercherDocParId("%"+idCherch+"%", p, s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("idCherch", idCherch);
		
		return "Document/afficherRevues";
	}
	
	@GetMapping("deleteRev")
	public String deleteRev(Model model,String id_doc,int page,int size,String idCherch) {
		documentService.deleteDoc(id_doc);
		
		return "redirect:/document/listerRev?page="+page+"&size="+size+"&idCherch="+idCherch;
	}
	
	@GetMapping("editRev")
	public String editRev(Model model,String id_doc) {
		Document document = documentService.getDocumentById(id_doc);
		model.addAttribute("document", document);
		return "Document/modifierRev";
	}
	
	
	
	
	
	@GetMapping("ajouterDic")
	public String formDic(Model model) {
		model.addAttribute("document", new Dictionnaire());
		return "Document/ajouterDic";
	}
	
	@PostMapping("saveDic")
	public String saveDic( @Valid Dictionnaire document,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "Document/ajouterDic";
		
	   
		documentService.ajouterDoc(document);
		
		
		return "redirect:/document/listerDic";
	}

	@GetMapping("listerDic")
	public String listerDic(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s,
            @RequestParam(name = "idCherch", defaultValue = "") String idCherch) {
		
		
	Page<Document> documents = documentService.chercherDocParId("%"+idCherch+"%", p, s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("idCherch", idCherch);
		
		return "Document/afficherDictionnaires";
	}
	
	@GetMapping("editDic")
	public String editDic(Model model,String id_doc) {
		Document document = documentService.getDocumentById(id_doc);
		model.addAttribute("document", document);
		return "Document/modifierDic";
	}
	
	@GetMapping("deleteDic")
	public String deleteDic(Model model,String id_doc,int page,int size,String idCherch) {
		documentService.deleteDoc(id_doc);
		
		return "redirect:/document/listerDic?page="+page+"&size="+size+"&idCherch="+idCherch;
	}
	
	
	
	
	
	
	
}
