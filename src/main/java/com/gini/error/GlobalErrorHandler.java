package com.gini.error;

import com.gini.error.exceptions.ResourceNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFound.class)
    ErrorResponse handleResourceNotFoundException(ResourceNotFound ex) {
        log.error("Error: ------> ", ex);
        return new ErrorResponse(ex.getMessage(), 404);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    ErrorResponse handle500(Exception ex) {
        log.error("Error: ------> ", ex);
        return new ErrorResponse(ex.getMessage(), 500);
    }

}
