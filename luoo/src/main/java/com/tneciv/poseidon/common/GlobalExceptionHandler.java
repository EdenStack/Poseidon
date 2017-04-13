package com.tneciv.poseidon.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Tneciv on 2017/3/28.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorObject> handleError500(Exception ex) throws Throwable {
        log.error("Internal error cause by : {}", ex.getMessage());
        ErrorObject errorObject = new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR,
                "500",
                "Internal error .",
                ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}