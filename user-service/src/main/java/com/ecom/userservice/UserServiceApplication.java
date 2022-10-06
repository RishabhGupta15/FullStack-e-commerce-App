package com.ecom.userservice;

import com.ecom.userservice.model.Role;
import com.ecom.userservice.model.User;
import com.ecom.userservice.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserServiceImpl userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "rishabh", "rishabh", new ArrayList<>()));
			userService.saveUser(new User(null, "luffy", "luffy", new ArrayList<>()));

			userService.addRoleToUser("luffy", "ROLE_USER");
			userService.addRoleToUser("rishabh", "ROLE_ADMIN");
			userService.addRoleToUser("rishabh", "ROLE_MANAGER");
		};
	}

}
