package com.shop.confoguration.exception.product;

public class ProductPriceException extends RuntimeException {


    public ProductPriceException(String massage) {
        super(massage);
    }

    public ProductPriceException(Throwable cause) {
        super(cause);
    }
}
