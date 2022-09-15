package com.ecom.webapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private Date timestamp = new Date();
    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }

}
