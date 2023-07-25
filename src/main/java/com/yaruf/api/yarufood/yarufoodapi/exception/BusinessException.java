package com.yaruf.api.yarufood.yarufoodapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException{
    HttpStatus httpStatus;
    String message;
    public BusinessException(HttpStatus httpStatus, String message){
        super();
        this.httpStatus = httpStatus;
        this.message = message;

    }
}
