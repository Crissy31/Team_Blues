package fr.ldnr.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {

// Attributs

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany (mappedBy = "category")
	private Collection<Article> articles;  // une categorie est liée à plusieurs Articles

// Constructeurs

	public Category(Long id, String name,Collection<Article> lstArticles) {
		this.id = id;
		this.name = name;
		this.articles = lstArticles;
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Category() {

	}

// Accesseurs

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

// Methodes

	@Override
	public String toString() {
		return "Category [id = " + id + ", name = " + name + "]";
	}

}