package com.shop.repository;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import com.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getByCategoryIn(List<Category> categories);


}
