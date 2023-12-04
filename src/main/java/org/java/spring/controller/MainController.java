package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	// Questo metodo gestisce le richieste GET sulla radice dell'applicazione
	@GetMapping
	public String getPizza(Model model,
			@RequestParam(required = false) String p) {
		
		List<Pizza> pizzas = p == null  
					? pizzaService.findAll()
					: pizzaService.findByName(p);
		
		model.addAttribute("pizze", pizzas);
		model.addAttribute("p", p == null ? "" : p);
		
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
	
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		
		return "pizzaCreate";
	}

	@PostMapping("/pizza/create")
    public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            System.out.println(bindingResult);

            model.addAttribute("pizza", pizza);
            return "pizzaCreate";
        }

        pizzaService.save(pizza);

        return "redirect:/";
    }
}
