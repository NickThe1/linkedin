package com.nick.software.link.linkedin.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

    private HttpStatus status;

    private String message;

    public ApiError(HttpStatus notFound, String errorMessage) {

    }
}
