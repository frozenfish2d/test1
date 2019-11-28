package com.itmo.example.t1.user.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Errors {
    ALREADY_EXIST,
    SUCCESS,
    BAD_LOGIN,
    EMPTY_PASSWORD,
    EMPTY_USERNAME,
    USERNAME_WRONG_FORMAT,
    PASSWORD_WRONG_FORMAT;




}

@Service
public class UserService {

    public static final int ALREADY_EXIST = 1;
    public static final int SUCCESS = 0;
    public static final int BAD_LOGIN = -1;
    public static final int EMPTY_PASSWORD = -2;
    public static final int EMPTY_USERNAME = -3;
    public static final int USERNAME_WRONG_FORMAT = -4;
    public static final int PASSWORD_WRONG_FORMAT = -5;
    private final Map<String, String> users = new HashMap<>();

    public int addUser(String userName, String password) throws NoSuchAlgorithmException {
        Pattern pattern;
        Matcher matcher;
        if (users.containsKey(userName)) {
            return ALREADY_EXIST;
        }

        if (userName == null || userName.equals("")) {
            return EMPTY_USERNAME;
        }


        pattern = Pattern.compile("^[a-zA-Z]{6,20}$");
        matcher = pattern.matcher(userName);
        if (!matcher.matches()) {
            return USERNAME_WRONG_FORMAT;
        }

        if (password == null || password.equals("")) {
            return EMPTY_PASSWORD;
        }


        //pattern = Pattern.compile("^[a-zA-Z0-9]{6,20}$");
        pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{6,20}");
        matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return PASSWORD_WRONG_FORMAT;
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.trim().getBytes());

        users.put(userName.trim(), password.trim());

        return SUCCESS;
    }

    public int login(String userName, String password) {

        if (users.containsKey(userName.trim()) && users.containsValue(password.trim()))
            return SUCCESS;

        return BAD_LOGIN;
    }

}
