package com.ecom.webapp.service;

import com.ecom.webapp.exception.ProductNotPresentException;
import com.ecom.webapp.model.Product;
import com.ecom.webapp.model.ProductResponse;
import com.ecom.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(String id)  {
        Product product = productRepository.findBypID(id);
        if(product == null) throw new ProductNotPresentException(id);
        return product;
    }

    public void updateProduct(ProductResponse newProductDetails) {
        Product product = productRepository.findBypID(newProductDetails.getPId());
        if(product == null) throw new ProductNotPresentException(newProductDetails.getPId());
        product.setProductName(newProductDetails.getProductName());
        product.setProductDescription(newProductDetails.getProductDescription());
        product.setPrice(newProductDetails.getPrice());
        product.setStockPresent(newProductDetails.getStockPresent());

        productRepository.save(product);
    }

    public void deleteProductByProductId(String pid) {
        Product product = productRepository.findBypID(pid);
        if(product == null) throw new ProductNotPresentException(pid);
        productRepository.delete(product);
    }

}
