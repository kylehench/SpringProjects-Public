package com.kylehench.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String displayForm() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji")
	public String submitForm(HttpSession session,
		@RequestParam(value="number") String number,
		@RequestParam(value="city") String city,
		@RequestParam(value="name") String name,
		@RequestParam(value="activity") String activity,
		@RequestParam(value="lifeform") String lifeform,
		@RequestParam(value="comment") String comment) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("activity", activity);
		session.setAttribute("lifeform", lifeform);
		session.setAttribute("comment", comment);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showOmikuji(HttpSession session, Model model) {
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("activity", session.getAttribute("activity"));
		model.addAttribute("lifeform", session.getAttribute("lifeform"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "show.jsp";
	}

}
