package com.moneylion.assignment.handler;

import com.moneylion.assignment.exception.CustomException;
import com.moneylion.assignment.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(CustomException customException) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(customException.getMessage());
        response.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.valueOf(customException.getCode()));
    }
}
