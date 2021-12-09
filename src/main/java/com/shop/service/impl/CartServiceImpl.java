package com.shop.service.impl;

import com.shop.confoguration.exception.NotFoundException;
import com.shop.dto.CartDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Cart;
import com.shop.entity.CartNode;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.repository.CartRepository;
import com.shop.service.CartNodeService;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    private UserService userService;
    private CartNodeService cartNodeService;
    private CartRepository repository;
    private ProductService productService;

    @Autowired
    public CartServiceImpl(UserService userService, CartNodeService cartNodeService, CartRepository repository, ProductService productService) {
        this.userService = userService;
        this.cartNodeService = cartNodeService;
        this.repository = repository;
        this.productService = productService;
    }

    @Override
    public CartDTO map(Cart cart) {
        return null;
    }

    @Override
    public Cart map(CartDTO cartDto) {
        return null;
    }

    @Override
    public Cart clearCurrentUserCart() {
        Cart cartByCurrentUser = getCartByCurrentUser();
        cartNodeService.deleteAll(cartByCurrentUser.getCartNodes());
        return cartByCurrentUser;
    }

    @Override
    public Cart addProductToCurrentUserCart(ProductDTO productDTO) {
        Cart cartByCurrentUser = getCartByCurrentUser();
        Long productId = productDTO.getId();
        CartNode byCartAndProduct = cartNodeService.getByCartAndProduct(productId, cartByCurrentUser);

        if (byCartAndProduct != null) {
            cartNodeService.addOneProduct(byCartAndProduct);
            return save(cartByCurrentUser);
        }
        Product product = productService.getOne(productId);
        CartNode cartNode = new CartNode();
        cartNode.setCount(1L);
        cartNode.setProduct(product);
        cartNode.setCart(cartByCurrentUser);
        cartNodeService.save(cartNode);
        cartByCurrentUser.getCartNodes().add(cartNode);
        return save(cartByCurrentUser);
    }

    @Override
    public Cart deleteProductFromCurrentUserCart(ProductDTO productDTO) {
        Cart cartByCurrentUser = getCartByCurrentUser();
        Long productId = productDTO.getId();
        CartNode byCartAndProduct = cartNodeService.getByCartAndProduct(productId, cartByCurrentUser);

        if (byCartAndProduct != null) {
            cartNodeService.deleteOneProduct(byCartAndProduct);
            return save(cartByCurrentUser);
        }
        throw new NotFoundException("This user dont have cart");
    }

    @Override
    @Transactional
    public Long getCartPrice(Long id) {

        Long total = 0L;
        Cart one = repository.getOne(id);
        for (CartNode cartNode : one.getCartNodes()) {
            total += cartNodeService.getCartNodePriceById(cartNode.getId());
        }
        return total;
    }


    private Cart getCartByCurrentUser() {
        User currentUser = userService.getCurrentUser();
        Cart byUser = repository.getByUser(currentUser);
        if (byUser != null) {
            return byUser;
        }
        byUser = new Cart();
        byUser.setUser(currentUser);
        byUser.setCartNodes(new ArrayList<>());
        return save(byUser);
    }

    private Cart save(Cart cart) {
        return repository.save(cart);
    }}