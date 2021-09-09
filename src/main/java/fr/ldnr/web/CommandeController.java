package fr.ldnr.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.ldnr.dao.ArticleRepository;
import fr.ldnr.dao.CategoryRepository;
import fr.ldnr.dao.CommandeRepository;
import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

@Controller
public class CommandeController {

	public List<Article> lstPanier = new ArrayList<>();
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping("/caddy")		
	public String caddy(Model model) {
		
		//List<Article> articlesCaddy = commandeRepository.findByCommande_id;
		//model.addAttribute("listArticlesCommande",articlesCaddy);
		
		return "caddy";//"caddy.html";
	}
	
	@PostMapping("/ajoutPanier")		
	public String ajoutPanier(Long id, Model model, @Valid Article article , BindingResult bindingResult) {
		///if(bindingResult.hasErrors())	return "caddy";	
		///lstPanier = articleRepository.findByCommande_id(id);
		///articleRepository.save(article_commande);
		return "articles";
	}
	
	/*@PostMapping("/save")		
	public String save(Model model, @Valid Article article , BindingResult bindingResult) {		
		if(bindingResult.hasErrors())	return "caddy";	
		// s'il n'y a pas de saisie d'un champ selon certains critères, pas d'insertion en base
		articleRepository.save(article_commande);
		return "articles";
	}*/
	
	
	
	public double montant(Collection<Article> articles) {
		double montant = 0;
		
		for (Article article : articles) {
            montant += article.getPrice();
        }
		
		System.out.println("MONTANT :::: " + montant);
		
		return montant;
	}
}
