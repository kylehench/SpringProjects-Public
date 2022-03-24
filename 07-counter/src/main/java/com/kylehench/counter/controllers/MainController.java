package com.kylehench.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping
	public String index(HttpSession session) {
		if (session.getAttribute("counter")==null) {
			session.setAttribute("counter", 0);
		} else {
			session.setAttribute("counter", (int) session.getAttribute("counter")+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if (session.getAttribute("counter")==null) {
			model.addAttribute("counter", 0);
		} else {
			model.addAttribute("counter", session.getAttribute("counter"));
		}
		return "counter.jsp";
	}

}