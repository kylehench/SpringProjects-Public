package com.kylehench.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylehench.dojosandninjas.services.DojoService;
import com.kylehench.dojosandninjas.models.Dojo;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	DojoService service;
	
	// new Dojo
	@GetMapping("/")
	public String new_dojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		// model.addAttribute("dojo", Dojo);
		return "new_dojo.jsp";
	}
	
	// create Dojo
	@PostMapping("/")
	public String create_dojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new_dojo.jsp";
		}
		service.create(dojo);
		return "redirect:/";
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