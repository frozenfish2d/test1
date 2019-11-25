package com.itmo.example.t1.calculate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Parameter data is not init")
public class WrongDataException extends RuntimeException {
}
