package com.ecom.webapp.controller;

import com.ecom.webapp.model.Product;
import com.ecom.webapp.model.ProductResponse;
import com.ecom.webapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping
    public ResponseEntity listAllProducts(){
        return new ResponseEntity(productServiceImpl.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewProduct(@RequestBody Product newProduct){
        productServiceImpl.addNewProduct(newProduct);
        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{pid}")
    public ResponseEntity findProductById(@PathVariable("pid") String pid)  {
        return new ResponseEntity(productServiceImpl.findProductById(pid), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateProductDetails(@RequestBody ProductResponse productResponse){
        productServiceImpl.updateProduct(productResponse);
        return new ResponseEntity(productServiceImpl.findProductById(productResponse.getPId()), HttpStatus.ACCEPTED);
    }
}
