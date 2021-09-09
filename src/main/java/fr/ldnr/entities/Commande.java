package fr.ldnr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commande{
	
	//  Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany (mappedBy = "commande")
	private Collection<Article> articles;  // une categorie est liée à plusieurs Articles
	
	//  Constructeurs
	
	public Commande(){

	}
	
	public Commande(Long id, Collection<Article> lstArticles ){
		this.id = id;
		this.articles = lstArticles;
	}

	public Long getId() {
		return id;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + "]";
	}
	
		
}
