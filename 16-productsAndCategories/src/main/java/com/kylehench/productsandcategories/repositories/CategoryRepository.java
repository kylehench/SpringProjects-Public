package com.kylehench.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.productsandcategories.models.Category;
import com.kylehench.productsandcategories.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	// this method retrieves all the users from the database
    List<Category> findAll();
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
