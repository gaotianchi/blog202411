package com.gaotianchi.backend.controller.hook;

import com.gaotianchi.backend.Response.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> R<T> handleException(Exception e) {
        System.out.println("unknown exception: " + e.getMessage());
        return R.error(e.getLocalizedMessage());
    }
}
