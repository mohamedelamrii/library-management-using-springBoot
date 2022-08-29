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
import com.mohamed.projet.entities.Emprunt;
import com.mohamed.projet.service.EmpruntService;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {
@Autowired
private EmpruntService empruntService;

@GetMapping("lister")
public String lister(Model model ,@RequestParam(name = "page", defaultValue = "0") int p
                                  ,@RequestParam(name = "size", defaultValue = "6") int s) {
	
	Page<Emprunt> emprunts = empruntService.getAllEmprunt(p,s);
	model.addAttribute("emprunts", emprunts.getContent());
	int[] nbrPages = new int [emprunts.getTotalPages()];
	model.addAttribute("nbrPages", nbrPages);
	model.addAttribute("size", s);
	model.addAttribute("pageCourante", p);
	
	return "Emprunt/index";
}

@GetMapping("ajouter")
public String formEmprunt(Model model) {
	model.addAttribute("emprunt", new Emprunt());
	model.addAttribute("adherent", new Adherent());
	return "Emprunt/ajouter";
}
	

@PostMapping("save")
public String saveAdherent(Model model ,Emprunt emprunt
		,@RequestParam(name = "date_Emprunt", defaultValue = "2022-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1,
		  @RequestParam(name = "date_retour", defaultValue = "2022-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2){
	
	
try {
	 empruntService.enregistrerEmp(emprunt);
} catch (Exception e) {
	model.addAttribute("error", e);
	return "redirect:/emprunt/ajouter?error="+e.getMessage();
}
 

	
	return "redirect:/emprunt/lister";
}
	
@GetMapping("edit")
public String edit(Model model,Long id_emprunt) {
	Emprunt emprunt = empruntService.getEmpruntById(id_emprunt);
	model.addAttribute("emprunt", emprunt);
	return "Emprunt/modifier";
}	
	
@GetMapping("delete")
public String delete(Model model,Long id_emprunt,int page,int size) {
	empruntService.deleteEmp(id_emprunt);
	
	return "redirect:/emprunt/lister?page="+page+"&size="+size;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
