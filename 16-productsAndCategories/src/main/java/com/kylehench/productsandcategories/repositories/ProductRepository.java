package com.kylehench.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.productsandcategories.models.Category;
import com.kylehench.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	// this method retrieves all the users from the database
    List<Product> findAll();
    
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
    
}