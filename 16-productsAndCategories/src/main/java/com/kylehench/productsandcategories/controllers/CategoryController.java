package com.kylehench.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.productsandcategories.models.Category;
import com.kylehench.productsandcategories.models.Product;
import com.kylehench.productsandcategories.services.CategoryService;
import com.kylehench.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
    
	// new category
    @GetMapping("/categories/new")
    public String categories_new(@ModelAttribute("newCategory") Category category) {
        return "categories_new.jsp";
    }
    @PostMapping("/categories/create")
    public String categories_create(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
    	if (result.hasErrors()) return "categories_new.jsp";
    	categoryService.create(category);
    	return "redirect:/";
    }
    
    // view category
    @GetMapping("/categories/{id}")
    public String categories_id(@PathVariable long id, Model model) {
    	Category category = categoryService.read(id);
    	model.addAttribute("category", category);
    	model.addAttribute("productsNotInCategory", productService.productsNotInCategory(category));
    	return "categories_id.jsp";
    }
    
    // update category
    @PutMapping("/categories/{id}")
    public String categories_update(@PathVariable long id, Model model,
    		@RequestParam(value="product_id") long product_id) {
    	System.out.println(id);
    	System.out.println(product_id);
    	categoryService.addProduct(id, product_id);
    	return "redirect:/categories/{id}";
    }
}