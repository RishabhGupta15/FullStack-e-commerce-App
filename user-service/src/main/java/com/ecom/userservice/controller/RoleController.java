package com.ecom.userservice.controller;

import com.ecom.userservice.model.Role;
import com.ecom.userservice.repository.RoleRepository;
import com.ecom.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity listAllRoles(){
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewRole(@RequestBody Role role){
        return new ResponseEntity(userService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping("/add/{user}")
    public ResponseEntity addRoleToUser(@PathVariable(value = "user") String username, @RequestBody Role role){
        userService.addRoleToUser(username, role.getRole());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
