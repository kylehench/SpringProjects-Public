package com.kylehench.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylehench.dojosandninjas.services.DojoService;
import com.kylehench.dojosandninjas.services.NinjaService;
import com.kylehench.dojosandninjas.models.Dojo;
import com.kylehench.dojosandninjas.models.Ninja;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	// new Ninja
	@GetMapping("/new")
	public String new_ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		 model.addAttribute("dojos", dojoService.all());
		return "new_ninja.jsp";
	}
	
	 // create Ninja
	@PostMapping("/create")
	public String create_ninja(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		 if (result.hasErrors()) {
			 // Ninjas error handling does not work, dropdown disappears
			 return "1";
			 // return "new_ninja.jsp";
		 }
		ninjaService.create(ninja);
		return "redirect:/ninjas/new";
	}

}