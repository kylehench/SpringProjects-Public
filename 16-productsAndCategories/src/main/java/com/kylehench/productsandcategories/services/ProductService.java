package com.kylehench.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.productsandcategories.models.Category;
import com.kylehench.productsandcategories.models.Product;
import com.kylehench.productsandcategories.repositories.CategoryRepository;
import com.kylehench.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	// create
    public Product create(Product newProduct) {
    	return repository.save(newProduct);
    }
    
    // read
    public Product read(Long id) {
        Optional<Product> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Product> readAll() {
        return repository.findAll();
    }
    // update
    public Product update(Product o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Product> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
	// find products not in category
	public List<Product> productsNotInCategory(Category category) {
		return repository.findByCategoriesNotContains(category);
	}
	// add category
	public Product addCategory(long productId, long categoryId) {
		Product product = this.read(productId);
		List<Category> categories = product.getCategories();
		Category newCategory = categoryRepository.findById(categoryId).get();
    	categories.add(newCategory);
    	product.setCategories(categories);
    	this.update(product);
    	return product;
	}
}
