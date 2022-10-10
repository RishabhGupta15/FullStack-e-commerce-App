package com.ecom.bff.api;

import com.ecom.bff.model.ProductResponse;
import com.ecom.bff.service.ProductFeignClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/api/product")
@CrossOrigin(value = "*")
public class ProductServiceApi {

    @Autowired
    ProductFeignClientImpl productFeignClient;

    @GetMapping("/list")
    public ResponseEntity listALlProducts(){
        return new ResponseEntity(productFeignClient.listAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity saveNewProduct(@RequestBody ProductResponse productDetails){
        return new ResponseEntity(productFeignClient.saveNewProduct(productDetails), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody ProductResponse productResponse) {
        return new ResponseEntity(productFeignClient.updateProduct(productResponse) ,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity deleteProduct(@PathVariable("pid") String pid){
        productFeignClient.deleteProduct(pid);
        return new ResponseEntity(HttpStatus.OK);
    }

}
