package com.yaruf.api.yarufood.yarufoodapi.exception;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientResponseErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( value = { BusinessException.class, Exception.class, RuntimeException.class})
    public ResponseEntity<ClientResponseErrorDTO> exceptionHandler(BusinessException exception){
        return new ResponseEntity<>(exception.getError(),exception.getHttpStatus());
    }

}
