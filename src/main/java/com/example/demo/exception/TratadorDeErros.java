package com.example.demo.exception;

import com.example.demo.dto.ErroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarErro400(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new ErroDTO(ex.getMessage(), 400));
    }
}