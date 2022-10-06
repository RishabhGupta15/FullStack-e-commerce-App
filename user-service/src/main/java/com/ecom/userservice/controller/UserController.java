package com.ecom.userservice.controller;

import com.ecom.userservice.entity.User;
import com.ecom.userservice.model.UserResponse;
import com.ecom.userservice.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    public ResponseEntity listUsers(){
        return new ResponseEntity(userService.listAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity saveUser(@RequestBody User user){
        return new ResponseEntity(userService.saveNewUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserResponse userDetails){
        log.info("update endpoint called");
        return new ResponseEntity(userService.updateUser(userDetails), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserResponse userDetails){
        log.info("login endpoint called");
        return new ResponseEntity(userService.validateLogin(userDetails), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{username}")
    public ResponseEntity findUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity(userService.findUserByUsername(username), HttpStatus.OK);
    }

}
