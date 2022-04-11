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
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	@Autowired
	private ProductRepository productRepository;
	
	// create
    public Category create(Category newCategory) {
    	return repository.save(newCategory);
    }
    
    // read
    public Category read(Long id) {
        Optional<Category> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Category> readAll() {
        return repository.findAll();
    }
    // update
    public Category update(Category o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Category> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);		
		}
	}
	// find categories not in product
	public List<Category> categoriesNotInProduct(Product product) {
		return repository.findByProductsNotContains(product);
	}
	// add product
	public Category addProduct(long categoryId, long productId) {
		Category category = this.read(categoryId);
		List<Product> products = category.getProducts();
		Product newProduct = productRepository.findById(productId).get();
		products.add(newProduct);
		category.setProducts(products);
		this.update(category);
		return category;
	}
}
