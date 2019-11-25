package com.itmo.example.t1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "PASSWORD can be 6-20 symbols " +
        "Password need to contain lower, upper, digits and special chars")
public class PasswordFormatException extends RuntimeException {
}
