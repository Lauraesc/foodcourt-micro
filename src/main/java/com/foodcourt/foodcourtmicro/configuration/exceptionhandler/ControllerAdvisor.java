package com.foodcourt.foodcourtmicro.configuration.exceptionhandler;


import com.foodcourt.foodcourtmicro.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static java.lang.Integer.valueOf;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionCodeResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        //que traiga el error de la primera posicion de la lista
        FieldError fieldError = ex.getFieldErrors().get(0);
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(valueOf(HttpStatus.BAD_REQUEST.value()), fieldError.getDefaultMessage(),
                        HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidUserRoleException.class)
    public ResponseEntity<ExceptionCodeResponse> handleUserNullException(InvalidUserRoleException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage(),
                        HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(NameAlreadyExistsException.class)
    public ResponseEntity<ExceptionCodeResponse> handleNameAlreadyExistsException(NameAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.CONFLICT.value()), ex.getMessage(),
                        HttpStatus.CONFLICT.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(NitAlreadyExistsException.class)
    public ResponseEntity<ExceptionCodeResponse> handleNitAlreadyExistsException(NitAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.CONFLICT.value()), ex.getMessage(),
                        HttpStatus.CONFLICT.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionCodeResponse> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage(),
                        HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionCodeResponse> handleConflictException(ConflictException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.CONFLICT.value()), ex.getMessage(),
                        HttpStatus.CONFLICT.name(), LocalDateTime.now()));
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ExceptionCodeResponse> handleInternalServerErrorException(InternalServerErrorException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.name(), LocalDateTime.now()));
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionCodeResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionCodeResponse(Integer.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage(),
                        HttpStatus.NOT_FOUND.name(), LocalDateTime.now()));
    }

}
