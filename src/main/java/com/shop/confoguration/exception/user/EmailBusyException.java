package com.shop.confoguration.exception.user;

public class EmailBusyException extends  RuntimeException{
    public EmailBusyException(String message) {
        super(message);
    }

    public EmailBusyException(Throwable cause) {
        super(cause);
    }
}
