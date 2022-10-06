package com.ecom.userservice.service;

import com.ecom.userservice.model.Role;
import com.ecom.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
