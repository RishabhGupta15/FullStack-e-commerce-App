package com.ecom.bff.service;

import com.ecom.bff.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "user-service" ,url = "${user-service.url}")
public interface UserFeignClient {

    @GetMapping("api/user/list")
    List<UserResponse> getUserList();

    @PostMapping("api/user/add")
    UserResponse saveUser(UserResponse userDetails);

    @PostMapping("api/user/login")
    UserResponse loginUser(UserResponse userDetails);
}
