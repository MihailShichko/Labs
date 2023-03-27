package com.bsuir.lr.Labs.exceptions;

import com.bsuir.lr.Labs.controllers.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgs(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException occurred");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        logger.error("ArithmeticException occurred");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
