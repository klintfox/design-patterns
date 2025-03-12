package com.klinux.exception;

public class InvalidCarModelException extends RuntimeException {
    public InvalidCarModelException(String message) {
        super(message);
    }
}