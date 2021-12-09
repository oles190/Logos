package com.shop.service.impl;

import com.shop.dto.CartNodeDTO;
import com.shop.entity.Cart;
import com.shop.entity.CartNode;
import com.shop.entity.Product;
import com.shop.repository.CartNodeRepository;
import com.shop.service.CartNodeService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartNodeServiceImpl implements CartNodeService {

    private CartNodeRepository repository;
    private ProductService productService;

    @Autowired
    public CartNodeServiceImpl(CartNodeRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Override
    public void deleteAll(List<CartNode> cartNodes) {
        repository.deleteAll(cartNodes);
    }

    @Override
    @Deprecated
    public CartNode update(CartNode cartNode) {
        return null;
    }

    @Override
    public CartNode addOneProduct(CartNode cartNode) {
        cartNode.setCount(cartNode.getCount() + 1);
        return repository.save(cartNode);
    }

    @Override
    public void deleteOneProduct(CartNode cartNode) {
        if (cartNode.getCount() <= 1){
            delete(cartNode);
            return;
        }
        cartNode.setCount(cartNode.getCount() - 1);
        repository.save(cartNode);
    }

    @Override
    public CartNode create(CartNodeDTO cartNodeDTO) {
        CartNode cartNode = new CartNode();
        cartNode.setCount(cartNodeDTO.getCount());
        cartNode.setProduct(cartNode.getProduct());
        return cartNode;
    }

    @Override
    public CartNodeDTO map(CartNode cartNode) {
        CartNodeDTO dto = new CartNodeDTO();
        dto.setCount(cartNode.getCount());
        dto.setProductDTO(productService.map(cartNode.getProduct()));
        return dto;
    }

    @Override
    @Deprecated
    public CartNode map(CartNodeDTO cartNodeDTO) {
        return null;
    }

    @Override
    public CartNode getByCartAndProduct(Long productId, Cart cart) {
        Product product = productService.getOne(productId);
        return repository.getByCartAndProduct(cart, product);
    }

    @Override
    public CartNode save(CartNode cartNode) {
        return repository.save(cartNode);
    }

    @Override
    public Long getCartNodePriceBy(CartNode cartNode) {
        return cartNode.getCount() * cartNode.getProduct().getPrice();
    }

    @Override
    public Long getCartNodePriceById(Long cartNodeId) {
        CartNode cartNode = repository.getById(cartNodeId);
        return cartNode.getCount() * cartNode.getProduct().getPrice();
    }

    private void delete(CartNode cartNode){
        repository.delete(cartNode);
    }
}