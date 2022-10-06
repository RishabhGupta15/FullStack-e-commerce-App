package com.ecom.userservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private Date timestamp = new Date();
    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }
}
