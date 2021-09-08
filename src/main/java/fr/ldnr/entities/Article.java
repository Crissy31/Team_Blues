package fr.ldnr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5,max=50)
	private String description;
	
	@DecimalMin("50")
	private double price;
	
	@ManyToOne
	private Category category; // plusieurs articles sont liés à une seule categorie

	
	
	public Article(Long id, String description, double price, Category category) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Article(Long id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public Article() {
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Methodes
	
	

	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", price=" + price + "]";
	}
	
}
