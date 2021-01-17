package com.nick.software.link.linkedin.exception;

public class PostExistsException extends RuntimeException {

    public PostExistsException(String message) {
        super("post existed" + message);
    }
}
