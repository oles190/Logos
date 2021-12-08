package com.shop.confoguration.exception.category;

import com.shop.confoguration.exception.NameCantBeNullException;

public class CategoryNameCantBeNullException extends NameCantBeNullException {
    public CategoryNameCantBeNullException(String message) {
        super(message);
    }

    public CategoryNameCantBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNameCantBeNullException(Throwable cause) {
        super(cause);
    }
}
