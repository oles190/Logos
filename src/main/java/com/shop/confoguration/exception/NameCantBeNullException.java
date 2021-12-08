package com.shop.confoguration.exception;

public class NameCantBeNullException extends RuntimeException{
    public NameCantBeNullException(String message) {
        super(message);
    }

    public NameCantBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameCantBeNullException(Throwable cause) {
        super(cause);
    }
}
