package com.example.springbootandswagger.exception;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // ResponseStatus
public class CustomExceptionHandler {

    @ExceptionHandler(CommandAcceptanceException.class)
    public ResponseEntity<Object> handleCommandAcceptanceException(CommandAcceptanceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(java.lang.NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(java.lang.NullPointerException ex) {
        return new ResponseEntity<>("Null pointer exception occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}