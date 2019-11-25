package com.itmo.example.t1.string.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request body should be not empty!!!")
public class RequestBodyItEmptyException extends RuntimeException {
}
