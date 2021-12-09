package com.shop.confoguration.exception.user;

public class NoLoggedUserException  extends  RuntimeException{

    public NoLoggedUserException(String message) {
        super(message);
    }

    public NoLoggedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLoggedUserException(Throwable cause) {
        super(cause);
    }
}
