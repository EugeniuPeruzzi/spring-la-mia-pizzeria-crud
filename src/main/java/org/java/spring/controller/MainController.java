package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	// Questo metodo gestisce le richieste GET sulla radice dell'applicazione
	@GetMapping("/")
	public String getPizza(Model model) {
		
		// Recupera una lista di oggetti Pizza dal servizio
		List<Pizza> pizza = pizzaService.findAll();
		
		// Aggiunge la lista di pizze al modello per renderla disponibile nella vista
		model.addAttribute("pizze", pizza);
		
		// Restituisce il nome della vista da visualizzare ("index" in questo caso)
		return "index";
	}
	
	// Questo metodo gestisce le richieste GET per visualizzare i dettagli di una pizza specifica
	@GetMapping("/pizza/{id}")
	public String getPizzaId(Model model,
			@PathVariable int id) {
		
		// Recupera una pizza specifica dal servizio utilizzando l'ID fornito
		Pizza pizzaId = pizzaService.findById(id);
		
		// Aggiunge la pizza al modello per renderla disponibile nella vista
		model.addAttribute("pizza", pizzaId);
		
		// Restituisce il nome della vista da visualizzare ("pizzaShow" in questo caso)
		return "pizzaShow";
	}
}
