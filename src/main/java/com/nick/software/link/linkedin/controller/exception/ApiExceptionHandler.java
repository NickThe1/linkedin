package com.nick.software.link.linkedin.controller.exception;

import com.nick.software.link.linkedin.exception.AccountDetailNotFoundException;
import com.nick.software.link.linkedin.exception.AccountExistsException;
import com.nick.software.link.linkedin.exception.AccountNotFoundException;
import com.nick.software.link.linkedin.persistence.payload.ExceptionPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {AccountNotFoundException.class, AccountDetailNotFoundException.class, AccountExistsException.class})
    public ResponseEntity<Object> handle(RuntimeException e){
        ExceptionPayload exceptionPayload = new ExceptionPayload(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exceptionPayload, HttpStatus.BAD_REQUEST);
    }
}
