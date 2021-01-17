package com.nick.software.link.linkedin.exception;

public class AccountExistsException extends RuntimeException {

    public AccountExistsException(String message) {
        super("account has already been created" + message);
    }
}
