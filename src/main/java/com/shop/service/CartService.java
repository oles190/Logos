package com.shop.service;

import com.shop.dto.CartDTO;
import com.shop.dto.ProductDTO;
import com.shop.entity.Cart;

public interface CartService {

    CartDTO map(Cart cart);

    Cart map(CartDTO cartDto);

    Cart clearCurrentUserCart();

    Cart addProductToCurrentUserCart(ProductDTO productDTO);

    Cart deleteProductFromCurrentUserCart(ProductDTO productDTO);

    Long getCartPrice(Long id);


}
