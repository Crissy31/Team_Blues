package fr.ldnr.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Article;
import fr.ldnr.entities.Commande;

  public interface CommandeRepository extends JpaRepository<Commande, Long> {

		  //public double montant(Collection<Article> articles);
	
	///  public List<Article> findByCommande_id(Long commande_Id); // Commande_id = commande_id de la Table article en Base
}