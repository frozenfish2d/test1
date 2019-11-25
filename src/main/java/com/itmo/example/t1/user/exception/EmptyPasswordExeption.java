package com.itmo.example.t1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Password can't be empty!!!")
public class EmptyPasswordExeption extends RuntimeException {
}
