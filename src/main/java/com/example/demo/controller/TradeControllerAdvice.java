package com.example.demo.controller;

import com.example.demo.exception.InvalidTradeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class TradeControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidTradeException.class)
    public ResponseEntity<?> notFoundException(final InvalidTradeException exception) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> assertionException(final IllegalArgumentException exception) {
        return  new ResponseEntity<>(exception, HttpStatus.NOT_ACCEPTABLE);
    }
}