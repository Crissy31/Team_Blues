package fr.ldnr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	
	//  Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//  Constructeurs
	
	public Commande(){

	}
	
	public Commande(Long id){
		this.id = id;
	}

	//  Accesseurs
	
	
	//  Méthodes
	
	
	
}
