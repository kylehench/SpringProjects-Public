package com.kylehench.studentrosteronetomany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
//	@Autowired
//	private ProductService productService;
    
    @GetMapping("/")
    public String index(Model model) {
//    	model.addAttribute("products", productService.readAll());
        return "redirect:/dorms";
    }    
}