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
        HandleError error = HandleError.builder().code("E-500").message(msg.getMessage()).build(); //Se utiliza el objeto HandleError para generar un código de tipo e-500 y que muestre todas las excepciones lanzadas desde los controladores
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // devuelve un response entity con el objeto error de HandleError con un estado de HTTP de un bad request que significa que la solicitud fue inválida
    }
}
