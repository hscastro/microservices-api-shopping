package com.ms.hscastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ms.hscastro.repositories.UserRepository;

@EnableEurekaClient
@SpringBootApplication
public class UserApiApplication  {
	
	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

}
