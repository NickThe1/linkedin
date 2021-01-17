package com.nick.software.link.linkedin.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super("Account is not found " + message);
    }
}
