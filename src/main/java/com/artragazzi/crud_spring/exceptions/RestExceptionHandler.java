package com.artragazzi.crud_spring.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientCPFNotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> cpfClientNotFound(ClientCPFNotFoundException exception) {
        System.out.println("Exceção capturada: " + exception.getMessage());
        ExceptionResponseBody responseError = new ExceptionResponseBody(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }
}
