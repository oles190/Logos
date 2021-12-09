package com.shop.repository;

import com.shop.entity.Cart;
import com.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {

    Cart getByUser(User user);

}
