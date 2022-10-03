package com.ecom.userservice.service;

import com.ecom.userservice.model.User;
import com.ecom.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }
}
