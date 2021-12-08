package com.shop.confoguration.exception.user;

public class WrongPasswordException extends  RuntimeException{
    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }
}
