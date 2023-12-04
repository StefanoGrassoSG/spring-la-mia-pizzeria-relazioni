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
	
	@GetMapping("/")
	public String getPizzas(Model model,
			@RequestParam(required = false) String search) {
		
		List<Pizza> pizza = search == null  
				? pizzaService.findAll()
				: pizzaService.findByName(search);
		
			model.addAttribute("pizza", pizza);
			model.addAttribute("search", search == null ? "" : search);

		return "index";
	}
	

	@GetMapping("/pizzas/{id}")
	public String getBook(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "single";
	}
	
	@GetMapping("/create")
	public String create(Model model)  {
		
		model.addAttribute("pizza", new Pizza());
		
		return "create";
	}
	
	@PostMapping("/pizzas/create")
	public String store(
			@Valid @ModelAttribute Pizza formPizza,
			BindingResult bindingResult,
			Model model){
		
		if(bindingResult.hasErrors()) {
		     model.addAttribute("pizza", formPizza);
			return "create";
			}
		
		pizzaService.save(formPizza);
		int savedPizza = formPizza.getId();
		
		 return "redirect:/pizzas/" + savedPizza;
	}
}
