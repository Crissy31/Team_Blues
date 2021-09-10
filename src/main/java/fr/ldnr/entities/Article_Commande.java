package fr.ldnr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Article_Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	//  Attributs 
	
	@Id 
	private Long article_id;
	
	@Id
	private Long commande_id;
	
	/*@OneToOne  //  1 article-commandé correspond à 1 article
	private Article article; 
	@OneToOne //  1 article-commandé appartient à 1 commande
	private Commande commande;
	*/
	//  Constructeurs
	
	public Article_Commande(Long article_id, Long commande_id) {
		this.article_id = article_id;
		this.commande_id = commande_id;
	}
	public Article_Commande() {
		
	}
	
	//  Accesseurs
	
	public Long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
	public Long getCommande_id() {
		return commande_id;
	}
	public void setCommande_id(Long commande_id) {
		this.commande_id = commande_id;
	}
	
}
