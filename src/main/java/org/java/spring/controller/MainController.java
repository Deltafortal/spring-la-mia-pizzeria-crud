package org.java.spring.controller;


import java.util.List;

import org.java.spring.pojo.Pizza;
import org.java.spring.serv.PizzaService;
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
	
	
	
	
	//********** Routes
	@GetMapping
	public String getPizzas(Model model, @RequestParam(required = false) String q) {
		
		
		List<Pizza> pizzas = q == null ? pizzaService.findAll() : pizzaService.findByName(q);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("q", q == null ? "" : q);
		
		return "index";
	}
	
	
	
	@GetMapping("/pizza/{id}")
	public String getBook(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
	
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
		
	}
	
	
	
	@PostMapping("/pizza/create")
	public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult ) {
		
		
		if (bindingResult.hasErrors()) {
			
			
			model.addAttribute("pizza", pizza);
			return "pizza-create";
			
		} else {
			
			pizzaService.save(pizza);
			return "redirect:/";
		}
		
		
		
	}
	
}
