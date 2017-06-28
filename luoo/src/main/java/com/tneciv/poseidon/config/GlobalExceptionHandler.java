package com.tneciv.poseidon.config;

import com.tneciv.poseidon.common.ApplicationException;
import com.tneciv.poseidon.common.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseWrapper handleError500(Exception ex) throws Throwable {
        ex.printStackTrace();
        log.error("[系统异常] : {}", ex);
        return ResponseWrapper.fail(ex.toString());
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseWrapper handleApplicationException(ApplicationException ex) throws Throwable {
        log.error("[运行期异常] : {}", ex.getMessage());
        return ResponseWrapper.fail(ex);
    }

}
