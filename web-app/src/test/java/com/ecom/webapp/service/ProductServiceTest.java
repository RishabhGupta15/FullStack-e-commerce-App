package com.ecom.webapp.service;

import com.ecom.webapp.model.Product;
import com.ecom.webapp.model.ProductResponse;
import com.ecom.webapp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository repository;

    private Product pro1;

    @BeforeEach
    void setup(){
        this.pro1 = new Product();
        this.pro1.setId(1L);
        this.pro1.setPID("pro1");
        this.pro1.setProductName("product name");
        this.pro1.setProductDescription("product description");
        this.pro1.setPrice(100);
        this.pro1.setStockPresent(1000);
    }

    @Test
    @DisplayName("list all products test")
    void testListAllProducts_withProductListPresent_returnsProductList(){
        when(repository.findAll()).thenReturn(List.of(pro1));

        assertNotNull(productService.getAllProducts());
        assertEquals(1, productService.getAllProducts().size());
    }

    @Test
    @DisplayName("save new product test")
    void testSaveNewProduct_withProductDetailsProvided_returnsProductObject(){
        when(repository.save(any(Product.class))).thenReturn(pro1);

        assertEquals(pro1, productService.addNewProduct(pro1));
    }

    @Test
    @DisplayName("update product test")
    void testUpdateProduct_withNewProductDetailsProvided_returnsUpdatedProduct(){
        ProductResponse updateDetails = new ProductResponse();
        updateDetails.setPId("pro1");
        updateDetails.setProductName("Updated Name");
        updateDetails.setProductDescription("Updated description");
        updateDetails.setPrice(50);
        updateDetails.setStockPresent(500);

        Product expectedResponse = new Product();
        expectedResponse.setId(1L);
        expectedResponse.setPID("pro1");
        expectedResponse.setProductName("Updated Name");
        expectedResponse.setProductDescription("Updated description");
        expectedResponse.setPrice(50);
        expectedResponse.setStockPresent(500);

        when(repository.findBypID(any(String.class))).thenReturn(pro1);
        productService.updateProduct(updateDetails);

        assertEquals(expectedResponse, pro1);

    }

}
