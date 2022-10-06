package com.ecom.bff;

import com.ecom.bff.model.UserResponse;
import com.ecom.bff.service.UserFeignClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class BffApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserFeignClientImpl userFeignClient){
		return args -> {
			userFeignClient.printAllUsers();
//			UserResponse newUser = userFeignClient.saveUser(new UserResponse(null, "newuser", "newpassword"));
//			log.info(newUser.toString());
		};
	}

}
