package com.itmo.example.t1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown registration error!!!")
public class UnknownRegistrationException extends RuntimeException {
}
