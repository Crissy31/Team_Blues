package fr.ldnr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Article;
import fr.ldnr.entities.Commande;

  public interface CommandeRepository extends JpaRepository<Commande, Long> {

	//public List<Article> lstPanier(Long category_Id);
}