package com.ecom.bff.service;

import com.ecom.bff.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserFeignClientImpl {
    @Autowired
    UserFeignClient userFeignClient;

    public void printAllUsers(){
        List<UserResponse> list = userFeignClient.getUserList();
        log.info(list.toString());
    }

    public List<UserResponse> listUsers(){
        return userFeignClient.getUserList();
    }

    public UserResponse saveUser(UserResponse userDetail){
        return userFeignClient.saveUser(userDetail);
    }

    public UserResponse login(UserResponse loginDetails){
        return userFeignClient.loginUser(loginDetails);
    }

}
