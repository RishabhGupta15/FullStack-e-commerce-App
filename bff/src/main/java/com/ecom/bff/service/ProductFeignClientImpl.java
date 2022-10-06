package com.ecom.bff.service;

import com.ecom.bff.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFeignClientImpl {

    @Autowired
    ProductFeignClient productFeignClient;

    public List<ProductResponse> listAllProducts(){
        return productFeignClient.getProductList();
    }

    public ProductResponse saveNewProduct(ProductResponse productDetails){
        return productFeignClient.addNewProduct(productDetails);
    }

    public ProductResponse updateProduct(ProductResponse productDetails){
        return productFeignClient.updateProduct(productDetails);
    }

    public void deleteProduct(String pid){
        productFeignClient.deleteProduct(pid);
    }
}
