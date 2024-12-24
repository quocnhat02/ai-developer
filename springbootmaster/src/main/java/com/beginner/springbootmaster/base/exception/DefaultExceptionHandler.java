package com.beginner.springbootmaster.base.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.List;

public class DefaultExceptionHandler {
    public ResponseEntity<ApiError> handleException(
            ResourceNotFoundException e,
            HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ZonedDateTime.now(),
                List.of()
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
