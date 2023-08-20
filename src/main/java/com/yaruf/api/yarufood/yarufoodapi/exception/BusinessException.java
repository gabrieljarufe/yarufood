package com.yaruf.api.yarufood.yarufoodapi.exception;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientResponseErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException{
    HttpStatus httpStatus;
    String message;
    Throwable cause;
    ClientResponseErrorDTO error;
    public BusinessException(HttpStatus httpStatus, String message){
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.error = new ClientResponseErrorDTO(httpStatus.value(),message);
    }

    public BusinessException(HttpStatus httpStatus, String message, Exception e){
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.cause = e.getCause();
        this.error = new ClientResponseErrorDTO(httpStatus.value(), e.getMessage(),e.getCause());
    }

    public BusinessException(BusinessException e){
        super();
        this.httpStatus = e.getHttpStatus();
        this.message = e.getMessage();
        this.cause = e.getCause();
        this.error = new ClientResponseErrorDTO(e.getHttpStatus().value(), e.getMessage(),e.cause);
    }
}
