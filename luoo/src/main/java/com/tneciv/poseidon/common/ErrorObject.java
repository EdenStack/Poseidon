package com.tneciv.poseidon.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ErrorObject {
    private HttpStatus status;
    private String errorCode;
    private String errorMessage;
    private String detailMessage;
}