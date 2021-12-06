package com.shop.confoguration.exception.product;

public class ProductDontHaveDescriptionException extends RuntimeException {
    public ProductDontHaveDescriptionException(String message) {
        super(message);
    }

    public ProductDontHaveDescriptionException(Throwable cause) {
        super(cause);
    }
}
