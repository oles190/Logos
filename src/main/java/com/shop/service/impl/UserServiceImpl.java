package com.shop.service.impl;

import com.shop.confoguration.exception.user.EmailBusyException;
import com.shop.confoguration.exception.user.PasswordNotEqualsException;
import com.shop.confoguration.exception.user.WrongEmailException;
import com.shop.confoguration.exception.user.WrongPasswordException;
import com.shop.dto.RegistryDTO;
import com.shop.entity.Role;
import com.shop.entity.User;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private  PasswordEncoder passwordEnCoder;
    private  UserRepository repository;

    @Autowired
  public UserServiceImpl(PasswordEncoder passwordEnCoder, UserRepository repository) {
    this.passwordEnCoder = passwordEnCoder;
    this.repository = repository;
  }

  @Override
    public User getByEmail(String email) {

        User user= repository.getByEmail(email);
        if(user==null){
            throw new WrongEmailException("Email "+ email + " not found!");
        }
        return user;
    }



    private User save(User user){
     return repository.save(user);
    }

    @Override
    public User createUser(RegistryDTO registryDTO) {
    User byEmail= getByEmail(registryDTO.getEmail());
    if(byEmail!=null){
      throw  new EmailBusyException("Email "+ registryDTO.getEmail() + " is busy");
    }

    if(! registryDTO.getPassword().equals(registryDTO.getConfirmPassword())) {
      throw new PasswordNotEqualsException("Password not equals!");
    }
      User user = new User();

      user.setEmail(registryDTO.getEmail());
    user.setPassword(passwordEnCoder.encode(registryDTO.getPassword()));
        user.setRole(Role.ROLE_USER);
        return save(user);
    }

    public  User getByEmailAndPassword(String email,String password){
    User user = getByEmail(email);

    boolean matches= passwordEnCoder.matches(password, user.getPassword()); // енкодить password і порявнює з user.getPassword
    if(matches){
        return  user;
    }
    throw  new WrongPasswordException("Password wrong!");
    }


}
