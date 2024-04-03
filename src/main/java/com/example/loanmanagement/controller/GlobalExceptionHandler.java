package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.ESignupError;
import com.example.loanmanagement.model.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String errorField = ex.getBindingResult().getFieldError().getField();
        ESignupError errorMessage;
        switch (errorField) {
            case "username":
                errorMessage = ESignupError.USERNAME_EXIST;
                break;
            case "password":
                errorMessage =  ESignupError.PASSWORD_SHORT;
                break;
            default:
                errorMessage =  ESignupError.USERNAME_EXIST;
                break;
        }
        return ResponseEntity.badRequest().body(new MessageResponse(errorMessage.toString()));
    }
}
