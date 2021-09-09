package fr.ldnr.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	//Page<Category> findByNameContains(String name, Pageable pageable);
	//Page<Article>   findByCategoryWhereDescriptionContains(Category category, String description, Pageable pageable);
	/*Page<Article>  findByCategory_id(Long id);*/
///	Collection<Article>  findByCategory_id(Long id);
//	public List<Article> findByBrand(String brand);
	//public List<Article> findById(Long id);
	Page<Category>	findByNameContains(String name , Pageable pageable);
}