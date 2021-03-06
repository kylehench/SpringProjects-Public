package com.kylehench.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylehench.dojosandninjas.services.DojoService;
import com.kylehench.dojosandninjas.services.NinjaService;
import com.kylehench.dojosandninjas.models.Dojo;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	// new Dojo
	 @GetMapping("/new")
	 public String new_dojo(@ModelAttribute("dojo") Dojo dojo) {
	 	return "new_dojo.jsp";
	 }
	
	// create Dojo
	@PostMapping("/create")
	public String create_dojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "new_dojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/new";
	}
	
	// view Dojos
	@GetMapping
	public String dojos(Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "view_dojos.jsp";
	}

	// Ninjas at Dojo
	@GetMapping("/{id}")
	public String ninjasAtDojo(@PathVariable("id") long id, Model model) {
		model.addAttribute("dojo", dojoService.read(id));
		model.addAttribute("ninjas", ninjaService.allFromDojoId(id));
		return "ninjas_at_dojo.jsp";
	}
	
	
//	@GetMapping("/expenses")
//	public String expenses(@ModelAttribute("expense") Dojo expense, Model model) {
//		List<Dojo> expenses = expenseService.allExpenses();
//		model.addAttribute("expenses", expenses);
//		return "index.jsp";
//	}
//	@PostMapping("/")
//	public String create(
//			@Valid @ModelAttribute("expense") Dojo expense,
//			BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<Dojo> expenses = expenseService.allExpenses();
//			model.addAttribute("expenses", expenses);
//			return "index.jsp";
//		} else {
//			expenseService.createExpense(expense);
//			return "redirect:/expenses";
//		}
//	}

}