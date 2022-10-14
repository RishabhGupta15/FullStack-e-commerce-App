package com.ecom.webapp.repository;

import com.ecom.webapp.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    private Product pro1;

    @BeforeEach
    void setup(){
        this.pro1 = new Product();
        this.pro1.setPID("pro1");
        this.pro1.setProductName("product name");
        this.pro1.setProductDescription("product description");
        this.pro1.setPrice(100);
        this.pro1.setStockPresent(1000);
    }

    @Test
    @DisplayName("save product test")
    public void testSave_withProductDetails_returnsProductObject(){
        Product savedProduct = productRepository.save(pro1);
        assertNotNull(savedProduct.getId());
    }

    @Test
    @DisplayName("list all products test")
    public void testListAllProducts_withProductsList_returnsProductList(){
        productRepository.save(pro1);

        List<Product> productList = (List<Product>) productRepository.findAll();
        assertEquals(1, productList.size());
    }

    @Test
    @DisplayName("find product by pid test")
    public void testFindProductByPid_withPidGiven_returnsProductObject(){
        Product savedProduct = productRepository.save(pro1);
        Product retrievedProduct = productRepository.findBypID("pro1");

        assertEquals(savedProduct, retrievedProduct);
    }

    @Test
    @DisplayName("delete product test")
    public void testDeleteProduct_withProductObjectGiven_returnsNull(){
        Product product = productRepository.save(pro1);
        productRepository.delete(product);

        assertNull(productRepository.findBypID("pro1"));
    }
}
