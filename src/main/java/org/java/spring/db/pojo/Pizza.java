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
	private int id;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	private String foto;
	private double price;
	
	public Pizza() {}
	
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
