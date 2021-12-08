package com.shop.service;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    Category create(CategoryDTO categoryDTO);

    void  delete(CategoryDTO categoryDTO);

    Category update(CategoryDTO categoryDTO);

    CategoryDTO map(Category category);

    Category map(CategoryDTO categoryDTO);

    List<Category> getAll();

    Category getOne(Long id);


}
