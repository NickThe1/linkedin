package com.nick.software.link.linkedin.exception;

public class AccountDetailNotFoundException extends RuntimeException {

    public AccountDetailNotFoundException(String message) {
        super("account details not found " + message);
    }
}
