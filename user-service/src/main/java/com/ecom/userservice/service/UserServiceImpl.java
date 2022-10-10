package com.ecom.userservice.service;

import com.ecom.userservice.entity.User;
import com.ecom.userservice.exception.UserNotPresentException;
import com.ecom.userservice.exception.WrongPasswordException;
import com.ecom.userservice.model.UserResponse;
import com.ecom.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByusername(username);
    }

    @Override
    public User saveNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findByusername(username);
        userRepository.delete(user);
    }

    @Override
    public User updateUser(UserResponse userDetails) {
        User user = findUserByUsername(userDetails.getUsername());
        user.setPwd(userDetails.getPwd());
        return userRepository.save(user);
    }

    @Override
    public User validateLogin(UserResponse loginDetails) {
        User loggedInUser = findUserByUsername(loginDetails.getUsername());
        log.info(loggedInUser.toString());
        if(loggedInUser == null){
            log.error(String.format("%s not present", loginDetails.getUsername()));
            throw new UserNotPresentException(loginDetails.getUsername());
        }else {
            if(loggedInUser.getPwd().equals(loginDetails.getPwd())) return loggedInUser;
            else throw new WrongPasswordException();
        }
    }
}
