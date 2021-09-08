package fr.ldnr.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
