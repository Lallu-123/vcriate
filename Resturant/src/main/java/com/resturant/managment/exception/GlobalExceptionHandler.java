package com.resturant.managment.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public String handleEmployeeNotFoundException(NotFoundException e){
        e.printStackTrace();
        return e.getMessage();
    }
}
