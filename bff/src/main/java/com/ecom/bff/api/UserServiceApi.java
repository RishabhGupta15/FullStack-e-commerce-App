package com.ecom.bff.api;

import com.ecom.bff.model.UserResponse;
import com.ecom.bff.service.UserFeignClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/api/user")
public class UserServiceApi {

    @Autowired
    UserFeignClientImpl userFeignClient;

    @GetMapping("/list")
    public ResponseEntity listAllUsers(){
        return new ResponseEntity(userFeignClient.listUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewUser(@RequestBody UserResponse newUser){
        return new ResponseEntity(userFeignClient.saveUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserResponse loginDetails){
        return new ResponseEntity(userFeignClient.login(loginDetails), HttpStatus.CREATED);
    }
}
