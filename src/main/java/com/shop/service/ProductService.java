package com.shop.service;

import com.shop.dto.CategoryDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Category;
import com.shop.entity.Product;

import java.util.List;

public interface ProductService {

    Product getOne(Long id);

    Product create(ProductDTO productDTO);

    List<Product> getAll();

    Product update(ProductDTO productDTO);

    List<Product> getAllByCategories(List<CategoryDTO> categoryDTOS);

    void delete (Long id);

    Product map(ProductDTO productDTO);

    ProductDTO map(Product product);


}
