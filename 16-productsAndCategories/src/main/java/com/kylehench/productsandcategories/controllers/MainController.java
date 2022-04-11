package com.kylehench.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kylehench.productsandcategories.services.CategoryService;
import com.kylehench.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
    
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("products", productService.readAll());
    	model.addAttribute("categories", categoryService.readAll());
        return "index.jsp";
    }    
}