package com.shop.confoguration.exception.user;

public class PasswordNotEqualsException extends  RuntimeException{
    public PasswordNotEqualsException(String message) {
        super(message);
    }

    public PasswordNotEqualsException(Throwable cause) {
        super(cause);
    }
}
