package com.ecom.userservice.controller;

import com.ecom.userservice.model.User;
import com.ecom.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity listAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewuser(User newUser){
        userService.addNewUser(newUser);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
