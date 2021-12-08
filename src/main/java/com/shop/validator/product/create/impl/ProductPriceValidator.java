package com.shop.validator.product.create.impl;

import com.shop.confoguration.exception.product.ProductPriceException;
import com.shop.entity.Product;
import com.shop.validator.product.create.ProductCreateValidator;
import org.springframework.stereotype.Component;


@Component
public class ProductPriceValidator implements ProductCreateValidator {


    @Override
    public void validate(Product product) {
        if(product.getPrice() ==null || product.getPrice()<0){
            throw new ProductPriceException("Price cant be null or less than 0!");
        }
    }
}
