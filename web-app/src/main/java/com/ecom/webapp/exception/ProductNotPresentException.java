package com.ecom.webapp.exception;

public class ProductNotPresentException extends RuntimeException{
    public ProductNotPresentException(String pId){
        super("product with id- " +pId+" is not present");
    }
}
