package com.itmo.example.t1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User Logging error")
public class UserLoggingError extends RuntimeException {
}
