package com.kylehench.productsandcategories.controllers;

import java.util.List;

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
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
    
	// new product
    @GetMapping("/products/new")
    public String products_new(@ModelAttribute("newProduct") Product product) {
        return "products_new.jsp";
    }
    @PostMapping("/products/create")
    public String products_create(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
    	if (result.hasErrors()) return "products_new.jsp";
    	productService.create(product);
    	return "redirect:/";
    }
    
    // view product
    @GetMapping("/products/{id}")
    public String products_id(@PathVariable long id, Model model) {
    	Product product = productService.read(id);
    	model.addAttribute("product", product);
    	model.addAttribute("categoriesNotInProduct", categoryService.categoriesNotInProduct(product));
    	return "products_id.jsp";
    }
    
    // update product
    @PutMapping("/products/{id}")
    public String products_update(@PathVariable long id, Model model,
    		@RequestParam(value="category_id") long category_id) {
    	productService.addCategory(id, category_id);
    	return "redirect:/products/{id}";
    }
}