package com.shop.controller;

import com.shop.dto.CategoryDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")

public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }



    @GetMapping("/{id}")
    private ProductDTO getOne(@PathVariable Long id){
        Product product=  service.getOne(id);
        return  service.map(product);
    }



    @PostMapping("/create")
    private ProductDTO create(@RequestBody ProductDTO productDTO){
        Product product= service.create(productDTO);
        return service.map(product);
    }


    @PostMapping("/update")
    private ProductDTO update(@RequestBody ProductDTO productDTO){
        Product product= service.update(productDTO);
        return service.map(product);

    }


    @GetMapping("/all")
    private List<ProductDTO> getAll(){
        List<Product> products =  service.getAll();
        List<ProductDTO> productDTOS=  products.stream()
                .map(product -> service.map(product))
                .collect(Collectors.toList());
        return  productDTOS;
    }





    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/category")
    private List<ProductDTO> getByCategories(@RequestBody List<CategoryDTO> categoryDTOS){
        List<Product> allByCategories=service.getAllByCategories(categoryDTOS);
      return   allByCategories.stream().map(product->service.map(product)).collect(Collectors.toList());


    }


}


