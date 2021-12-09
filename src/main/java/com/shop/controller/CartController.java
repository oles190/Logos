package com.shop.controller;


import com.shop.dto.CartDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartDTO addProduct(@RequestBody ProductDTO productDTO){
        Cart cart=  cartService.addProductToCurrentUserCart(productDTO);
        return  cartService.map(cart);
    }

    @PostMapping("/delete")
    public CartDTO deleteProduct(@RequestBody ProductDTO productDTO){
        Cart cart=  cartService.deleteProductFromCurrentUserCart(productDTO);
        return  cartService.map(cart);
    }
}
