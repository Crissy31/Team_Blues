package fr.ldnr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.ldnr.dao.CategoryRepository;
import fr.ldnr.dao.CommandeRepository;
import fr.ldnr.entities.Category;

public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;
	
	@GetMapping("/ajoutPanier")		
	public String ajoutPanier(Model model) {
		//model.addAttribute("category" , new Category());		//injection d'une category par défaut dans le formulaire de la vue category
		return "redirect:/articlesByCategory?id=1";//"category";
	}
}
