package com.ecom.userservice.exception;

public class UserNotPresentException extends RuntimeException{
    public UserNotPresentException(String username){
        super("username :" + username + " not registered");
    }
    public UserNotPresentException(){
        super("user not registered");
    }
}
