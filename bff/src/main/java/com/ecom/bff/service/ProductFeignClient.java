package com.ecom.bff.service;

import com.ecom.bff.model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service", url="${product-service.url}", path = "api/products")
public interface ProductFeignClient {

    @GetMapping("/")
    List<ProductResponse>  getProductList();

    @PostMapping("/add")
    ProductResponse addNewProduct(ProductResponse productDetails);

    @GetMapping("/{pid}")
    ProductResponse findProductByProductId(@PathVariable("pid") String pid);

    @PutMapping("/update")
    ProductResponse updateProduct(ProductResponse productDetails);

    @DeleteMapping("/{pid}")
    void deleteProduct(@PathVariable("pid") String pid);

}
