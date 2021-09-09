package fr.ldnr.web;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ldnr.dao.ArticleRepository;
import fr.ldnr.dao.CategoryRepository;
import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

@Controller
public class CategoryController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("articlesByCategory")
	public String articlesByCategory(Long id, Model model, @RequestParam(name="page" , defaultValue = "0") int page, 
			 @RequestParam(name="keyword" , defaultValue = "") String kw) {
		
		// Début modif
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("listCategories",categories);
		
		// Fin modif
		
		Collection<Article> articles = articleRepository.findByCategory_id(id);
		model.addAttribute("listArticle",articles);	
		
		return "articles";
	}
	
	@GetMapping("/category")			 
	public String category(Model model, @RequestParam(name="page" , defaultValue = "0") int page, 
									 @RequestParam(name="keyword" , defaultValue = "") String kw) {	
		Page<Category> categories = categoryRepository.findByNameContains(kw , PageRequest.of(page, 5));	

		model.addAttribute("listCategories",categories.getContent());	//pour récupérer sous forme de liste la page pointée		
		model.addAttribute("pages", new int[categories.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",kw);
		
		return "categories";	
	}
	
	
	@GetMapping("/creerCategory")		
	public String creerCategory(Model model) {
		model.addAttribute("category" , new Category());		//injection d'une category par défaut dans le formulaire de la vue category
		return "category";
	}
	
	@GetMapping("/deleteCategory")		//on peut ne pas préciser le paramètre de la requete, il va rechercher les variables correspondantes
	public String deleteCategory(Long id, int page, String keyword) {
		categoryRepository.deleteById(id);		
		return "redirect:/category?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping("/editCategory")
	public String editCategory(Long id, Model model) {
		Category category = categoryRepository.getById(id);
		model.addAttribute("category", category);
		return "editCategory";
	}
	
	@PostMapping("/saveCategory")		
	public String saveCategory(Model model, @Valid Category category , BindingResult bindingResult) {		
		if(bindingResult.hasErrors())	return "category";	
		// s'il n'y a pas de saisie d'un champ selon certains critères, pas d'insertion en base
		categoryRepository.save(category);
		return "redirect:/category";
	}
}
