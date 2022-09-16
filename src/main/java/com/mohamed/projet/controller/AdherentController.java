package com.mohamed.projet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Emprunt;
import com.mohamed.projet.service.AdherentService;
import com.mohamed.projet.service.EmpruntService;

@Controller
@RequestMapping("/adherent")
public class AdherentController {
@Autowired
private AdherentService adherentService;
@Autowired
private EmpruntService empruntService;
@GetMapping("lister")

public String getAllAdherent(Model model,
		                     @RequestParam(name = "page", defaultValue = "0") int p,
		                     @RequestParam(name = "size", defaultValue = "6") int s,
		                     @RequestParam(name = "cin", defaultValue = "") String cin) {
	
	Page<Adherent>  adherents = adherentService.chercherAdhParCIN("%"+cin+"%", p, s);
	model.addAttribute("adherents", adherents.getContent());
	int[] nbrPages = new int [adherents.getTotalPages()];
	model.addAttribute("nbrPages", nbrPages);
	model.addAttribute("size", s);
	model.addAttribute("pageCourante", p);
	model.addAttribute("cin", cin);
	return "Adherent/index";
}

@GetMapping("delete")
public String deleteAdh(Model model,Long id_adherent,int page,int size,String cin) {
        Adherent adherent22 = adherentService.getAdherentById(id_adherent);
	Page<Emprunt> pages= empruntService.consulterEmprunt(adherent22,0,5);
	if (pages != null){
		for(Emprunt e: pages){
			empruntService.deleteEmp(e.getId_emprunt());
		}
	}
	adherentService.deleteAdh(id_adherent);
	
	return "redirect:/adherent/lister?page="+page+"&size="+size+"&cin="+cin;
}

@GetMapping("ajouter")
public String form(Model model) {
	model.addAttribute("adherent", new Adherent());
	return "Adherent/ajouter";
}
@GetMapping("edit")
public String edit(Model model,Long id_adherent) {
	Adherent adherent = adherentService.getAdherentById(id_adherent);
	model.addAttribute("adherent", adherent);
	return "Adherent/modifier";
}
 	
@PostMapping("save")
public String saveAdherent(
		@RequestParam(name = "dateDeNaissance", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
		,@Valid Adherent adherent
		,BindingResult bindingResult){
	if (bindingResult.hasErrors())
		return "Adherent/ajouter";
	
 
	adherentService.ajouterAdh(adherent);
	
	
	return "redirect:/adherent/lister";
}

@GetMapping("consulter")
public String form(Model model,Long id_adherent) {
	Adherent a =adherentService.getAdherentById(id_adherent);
	Page<Emprunt> emprunts = empruntService.consulterEmprunt(a, 0, 4);
	model.addAttribute("emprunts", emprunts);
	model.addAttribute("adherent", a);
	return "Emprunt/consultation";
}	
	
	
	
	
	
	

}
