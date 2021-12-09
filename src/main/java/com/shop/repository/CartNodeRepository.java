package com.shop.repository;

import com.shop.entity.Cart;
import com.shop.entity.CartNode;
import com.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartNodeRepository extends JpaRepository<CartNode, Long> {

    CartNode getByCartAndProduct(Cart cart, Product product);
}
