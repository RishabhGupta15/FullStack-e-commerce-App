package com.ecom.webapp.repository;

import com.ecom.webapp.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findBypID(String pid);
}
