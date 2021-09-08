package fr.ldnr.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ldnr.entities.Article;
import fr.ldnr.entities.Category;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Page<Article>	findByDescriptionContains(String description , Pageable pageable);
	public List<Article> findByCategory_id(Long category_Id); // Category_id = category_id de la Table article en Base
}
