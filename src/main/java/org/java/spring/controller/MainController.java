package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
