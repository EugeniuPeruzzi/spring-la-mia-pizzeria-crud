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
	
	@GetMapping
	public String getPizza(Model model) {
		
		List<Pizza> pizza = pizzaService.findAll();
		
		model.addAttribute("pizze", pizza);
		return "index";
		
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizzaId(Model model,
			@PathVariable int id) {
		
		Pizza pizzaId = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizzaId);
		return "pizzaShow";
		
	}
}
