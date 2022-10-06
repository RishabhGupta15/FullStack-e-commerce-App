package com.ecom.userservice.service;

import com.ecom.userservice.entity.User;
import com.ecom.userservice.model.UserResponse;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();
    User findUserByUsername(String username);
    User saveNewUser(User newUser);
    void deleteUser(String username);
    User updateUser(UserResponse userDetails);
    User validateLogin(UserResponse loginDetails);

}
