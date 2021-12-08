package com.shop.confoguration.exception.handler;


import com.shop.confoguration.exception.NameCantBeNullException;
import com.shop.confoguration.exception.NotFoundException;
import com.shop.confoguration.exception.product.ProductDontHaveDescriptionException;
import com.shop.confoguration.exception.product.ProductDontHaveNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler (value = NotFoundException.class)
    protected ResponseEntity handle(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage() ,HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler (value = IllegalArgumentException.class)
    protected ResponseEntity handle(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler (value = NameCantBeNullException.class)
    protected ResponseEntity handle(NameCantBeNullException ex) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler (value = ProductDontHaveDescriptionException.class)
    protected ResponseEntity handle(ProductDontHaveDescriptionException ex) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }



}
