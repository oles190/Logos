package com.shop.service.impl;

import com.shop.confoguration.exception.category.CategoryNotFoundException;
import com.shop.dto.CategoryDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.validator.product.create.ProductCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final List<ProductCreateValidator> createValidators;

@Autowired
    public ProductServiceImpl(ProductRepository repository,
     CategoryService categoryService, List<ProductCreateValidator> createValidators) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.createValidators = createValidators;
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product product =map(productDTO);
        createValidators.forEach(validator->validator.validate(product));
        return repository.save(product);

    }

    @Override
    public Product getOne(Long id) {
    Optional<Product> byId= repository.findById(id);
        if((byId.isPresent())){
            return byId.get();
        }
        throw  new CategoryNotFoundException("Product with id "+ id +" not found");
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product update(ProductDTO productDTO) {
        if (productDTO.getId()==null){
            throw  new IllegalArgumentException("Id cant be null!");
        }
        Product product = map(productDTO);
        return repository.save(product);
    }

    @Override
    public List<Product> getAllByCategories(List<CategoryDTO> categoryDTOS) {
       List<Category> categories= categoryDTOS.stream()
               .map(categoryService::map)
        //       .map(categoryDTO -> categoryService.map(categoryDTO))
               .collect(Collectors.toList());
        return repository.getByCategoryIn(categories);
    }

    @Override
    public void delete(Long id) {
        if (id==null){
            throw  new IllegalArgumentException("Id cant be null!");
        }
        repository.deleteById(id);
    }

    @Override
    public Product map(ProductDTO productDTO) {

        Product product= new Product();
        product.setCapacity(productDTO.getCapacity());
        product.setDescription(productDTO.getDescription());
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        Category category= categoryService.getOne(productDTO.getCategoryDTO().getId());
       product.setCategory(category);

        return product;
    }


    @Override
    public ProductDTO map(Product product) {
    ProductDTO productDTO =  new ProductDTO(product);
             return  productDTO;

    }
}
