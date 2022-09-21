package com.ecom.webapp.service;

import com.ecom.webapp.exception.ProductNotPresentException;
import com.ecom.webapp.model.Product;
import com.ecom.webapp.model.ProductResponse;

import java.util.List;

public interface ProductServiceInterface {

    List<Product> getAllProducts();
    void addNewProduct(Product product);
    Product findProductById(String id);
    void updateProduct(ProductResponse newProductDetails);
    void deleteProductByProductId(String pid);

}
