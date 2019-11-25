package com.itmo.example.t1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "USERNAME can be 6-20 symbols and contain only characters")
public class UserNameFormatExeption extends RuntimeException {
}
