package com.CalebArce.SecondProject.error;

import com.CalebArce.SecondProject.error.dto.HandleError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HandleError> runtimeExceptionHandler(RuntimeException msg) {
        HandleError error = HandleError.builder().code("E-500").message(msg.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //@RestControllerAdvice
}
