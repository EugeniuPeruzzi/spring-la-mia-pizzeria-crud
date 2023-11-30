package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  // Identificatore univoco della pizza

	private String name;  // Nome della pizza
	
	@Column(columnDefinition = "TEXT")
	private String description;  // Descrizione della pizza
	
	private String foto;  // URL dell'immagine della pizza
	
	private double price;  // Prezzo della pizza
	
	// Costruttore vuoto richiesto da JPA
	public Pizza() {}
	
	// Costruttore per creare una nuova pizza con informazioni iniziali
	public Pizza(String name, String description, String foto, double price) {
		setName(name);
		setDescription(description);
		setFoto(foto);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	// Metodo toString per la rappresentazione testuale dell'oggetto Pizza
	@Override
	public String toString() {
	    return 
	        "id= " + getId() +
	        "name= " + getName() + '\'' +
	        "description= " + getDescription() + '\'' +
	        "foto= " + getFoto() + '\'' +
	        "price= " + getPrice() ;
	}
}
