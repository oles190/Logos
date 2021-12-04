package com.shop.service.impl;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import com.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;

@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryDTO categoryDTO) {
        Category category=map(categoryDTO);
        return categoryRepository.save(category);

    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
    categoryRepository.deleteById(categoryDTO.getId());
    }

    @Override
    public Category update(CategoryDTO categoryDTO) {
 Category category = map(categoryDTO);
 return categoryRepository.save(category);

}

    @Override
    public CategoryDTO map(Category category) {

    CategoryDTO categoryDTO= new CategoryDTO();
    categoryDTO.setId(category.getId());
    categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    @Override
    public Category map(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setId(categoryDTO.getId());
    category.setName(categoryDTO.getName());
        return category;
    }

    @Override
    public List<Category> getAll() {
    return  categoryRepository.findAll();
    }

    @Override
    public Category getOne(Long id) {
   Optional<Category> byId= categoryRepository.findById(id);
   if(byId.isPresent()){
       return  byId.get();
   }
   throw  new IllegalArgumentException("Product witch id "+ id + " not found");

    }
}
