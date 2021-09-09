package fr.ldnr.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.ldnr.dao.CategoryRepository;
import fr.ldnr.dao.CommandeRepository;
import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

@Controller
public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;
	
	@GetMapping("/caddy")		
	public String caddy() {
		//model.addAttribute("category" , new Category());		//injection d'une category par défaut dans le formulaire de la vue category
		return "caddy";//"caddy.html";
	}
	
	
	public double montant(Collection<Article> articles) {
		double montant = 0;
		
		for (Article article : articles) {
            montant += article.getPrice();
        }
		
		System.out.println("MONTANT :::: " + montant);
		
		return montant;
	}
}
