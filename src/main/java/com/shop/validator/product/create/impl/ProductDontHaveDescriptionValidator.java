package com.shop.validator.product.create.impl;

import com.shop.confoguration.exception.product.ProductDontHaveDescriptionException;
import com.shop.entity.Product;
import com.shop.validator.product.create.ProductCreateValidator;
import org.springframework.stereotype.Component;


@Component
public class ProductDontHaveDescriptionValidator implements ProductCreateValidator {
    @Override
    public void validate(Product product) {

        if(product.getDescription()==null || product.getDescription().isEmpty()){
            throw new ProductDontHaveDescriptionException("Cant create product without description!");
        }

    }
}
