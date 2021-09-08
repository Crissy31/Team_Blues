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

@Controller
public class CategoryController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("articlesByCategory")
	public String articlesByCategory(Long id, Model model, @RequestParam(name="page" , defaultValue = "0") int page, 
			 @RequestParam(name="keyword" , defaultValue = "") String kw) {
		
		//Page<Article> articles = articleRepository.findByCategoryWhereDescriptionContains(id, kw , PageRequest.of(page, 5));	
		//Page<Article> articles = articleRepository.ArticlesByCategory(id, kw,  PageRequest.of(page, 5));
		
		
		
		/*Page<Article> articles = categoryRepository.findByCategory_id(id);//,  PageRequest.of(page, 5));*/
		///Collection<Article> articles = categoryRepository.findByCategory_id(id);
		
		Collection<Article> articles = articleRepository.findByCategory_id(id);
		///		Page<Article> articles = categoryRepository.findByCategoryWhereDescriptionContains(categoryRepository.findById(id), kw, PageRequest.of(page, 5));
		
		model.addAttribute("listArticle",articles);//.getContent());	//pour récupérer sous forme de liste la page pointée		
		
		return "articles";
	}
}
