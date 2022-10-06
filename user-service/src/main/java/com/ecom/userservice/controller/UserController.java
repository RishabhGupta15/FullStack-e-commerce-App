package com.ecom.userservice.controller;

import com.ecom.userservice.model.User;
import com.ecom.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity listAllUsers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewUser(@RequestBody User newUser){
        return new ResponseEntity(userService.saveUser(newUser), HttpStatus.CREATED);
    }
}
