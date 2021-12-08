package com.shop.confoguration.exception.user;

public class WrongEmailException extends  RuntimeException {
    public WrongEmailException(String message) {
        super(message);
    }

    public WrongEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongEmailException(Throwable cause) {
        super(cause);
    }
}
