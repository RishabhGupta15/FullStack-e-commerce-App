package com.ecom.webapp.controller;

import com.ecom.webapp.model.Product;
import com.ecom.webapp.model.ProductResponse;
import com.ecom.webapp.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerWebLayerTest {
    Product productObj;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    ProductServiceImpl productService;

    @BeforeEach
    void setup(){
        productObj = new Product();
        productObj.setPID("pro1");
        productObj.setProductName("test product");
        productObj.setProductDescription("test description");
        productObj.setPrice(100);
        productObj.setStockPresent(1000);
    }

    @Test
    public void testCreateProduct() throws Exception {

        when(productService.addNewProduct(any(Product.class))).thenReturn(productObj);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/products/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productObj));

        //ResultActions resultActions = mockMvc.perform(requestBuilder);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        System.out.println("output");
        System.out.println(response);

        Product responseProduct = objectMapper.readValue(response, Product.class);

        assertEquals(productObj, responseProduct);

    }

    @Test
    void testListAllProducts() throws Exception{

        List<Product> productList = new ArrayList<>();
        productList.add(productObj);

        when(productService.getAllProducts()).thenReturn(productList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        System.out.println(response);

        assertNotNull(response);
    }
}
