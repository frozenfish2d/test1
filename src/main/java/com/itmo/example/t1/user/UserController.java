package com.itmo.example.t1.user;

import com.itmo.example.t1.user.exception.*;
import com.itmo.example.t1.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String register(@RequestHeader(value = "user_name") String userName,
                           @RequestHeader(value = "password") String password) throws NoSuchAlgorithmException {
        int result = userService.addUser(userName, password);

        switch (result) {
            case UserService.SUCCESS:
                return "User success registered";
            case UserService.ALREADY_EXIST:
                throw new AlreadyRegisteredException();
            case UserService.EMPTY_USERNAME:
                throw new EmptyUserNameExeption();
            case UserService.USERNAME_WRONG_FORMAT:
                throw new UserNameFormatExeption();
            case UserService.EMPTY_PASSWORD:
                throw new EmptyPasswordExeption();
            case UserService.PASSWORD_WRONG_FORMAT:
                throw new PasswordFormatException();
            default:
                throw new UnknownRegistrationException();
        }
    }

    @GetMapping(value = "/login")
    public String login(@RequestHeader(value = "user_name") String userName,
                        @RequestHeader(value = "password") String password) {
        int result = userService.login(userName, password);

        switch (result) {
            case UserService.SUCCESS:
                return "User success logged in";
            case UserService.BAD_LOGIN:
                throw new UserLoggingError();
            default:
                throw new UnknownRegistrationException();
        }
    }
}
