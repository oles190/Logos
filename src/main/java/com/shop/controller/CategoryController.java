package com.shop.controller;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import com.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("/all")
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryService.getAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
        return categoryDTOS;
    }


    @PostMapping("/create")
    public CategoryDTO create(@RequestBody CategoryDTO categoryDTO){
Category category =categoryService.create(categoryDTO);
return  categoryService.map(category);

    }


    @PostMapping("/update")
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO){

        if(categoryDTO.getId()==null){
            throw  new IllegalArgumentException("id is null");
        }
        Category category =categoryService.create(categoryDTO);
        return  categoryService.map(category);
    }


    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id){

     Category category = categoryService.getOne(id);
     return  categoryService.map(category);


    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody CategoryDTO categoryDTO){
        categoryService.delete(categoryDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }




}
