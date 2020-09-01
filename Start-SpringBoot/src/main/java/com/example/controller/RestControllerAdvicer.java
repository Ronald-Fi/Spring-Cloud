package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerAdvicer {
    @ExceptionHandler(NullPointerException.class)
    public Object handlerNotFound(HttpStatus status, HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));
        errors.put("message", throwable.getMessage());
        return errors;
    }
}
