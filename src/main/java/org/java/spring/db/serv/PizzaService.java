package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	public PizzaRepository pizzaRepository;  // Iniezione di dipendenza del repository di Pizza

	// Metodo per recuperare tutte le pizze dal repository
	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}

	// Metodo per trovare una pizza per ID dal repository
	public Pizza findById(int id) {
		return pizzaRepository.findById(id).get();
	}

	// Metodo per salvare una pizza nel repository
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	public List<Pizza> findByName(String query) {
		return pizzaRepository.findByNameContainingIgnoreCase(query);
	
	}
	
	public void delete(Pizza pizza) {
		
		pizzaRepository.delete(pizza);
	}
	public void deleteById(int id) {
		
		pizzaRepository.deleteById(id);
	}
}
