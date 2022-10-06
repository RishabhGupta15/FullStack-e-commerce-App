package com.ecom.userservice.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super("wrong password");
    }
}
