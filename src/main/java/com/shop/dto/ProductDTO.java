package com.shop.dto;


import com.shop.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {


    private  Long id;

    private String name;

    private String description;

    private  Long price;

    private CategoryDTO categoryDTO;

    private  Long capacity;


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.categoryDTO = new CategoryDTO(product.getCategory());
        this.capacity = product.getCapacity();
    }


}
