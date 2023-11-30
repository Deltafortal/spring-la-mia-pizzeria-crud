package org.java.spring.controller;


import java.util.List;

import org.java.spring.pojo.Pizza;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	
	@Autowired
	private PizzaService pizzaService;
	
	
	
	
	//********** Routes
	@GetMapping
	public String getPizzas(Model model) {
		
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		for (Pizza p : pizzas) System.out.println(p.getNome());
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	
	
	
	@GetMapping("/pizza/{id}")
	public String getBook(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
	
}
