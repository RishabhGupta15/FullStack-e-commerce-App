package com.ecom.userservice.exception;

import com.ecom.userservice.model.ErrorResponse;
import org.hibernate.hql.internal.ast.ErrorReporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotPresentException.class)
    public final ResponseEntity userNotPresentExceptionHandler(UserNotPresentException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public final ResponseEntity wrongPasswordExceptionHandler(WrongPasswordException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
