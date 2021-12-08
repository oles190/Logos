package com.shop.service;

import com.shop.dto.RegistryDTO;
import com.shop.entity.User;

public interface UserService {

    User getByEmail(String email);

    User createUser(RegistryDTO registryDTO);
    User getByEmailAndPassword(String email , String password);

}
