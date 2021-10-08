package com.ms.hscastro;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ms.hscastro.entities.User;
import com.ms.hscastro.repositories.UserRepository;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		initiateUser();		
	}
	
	
	//método para testes rapido
	public void initiateUser() {
		User u1 = new User(1L, "Halyson", "123", "Rua b", "test1@test.com","9123-9090", new Date());
		User u2 = new User(2L, "Antonio", "234", "Rua c", "test2@test.com","9123-9092", new Date());
		User u3 = new User(3L, "Maria", "235", "Rua d", "test3@test.com","9123-9093", new Date());		
//		UserDTO userDTO1 = UserDTO.convertToUser(u1);
//		UserDTO userDTO2 = UserDTO.convertToUser(u2);
//		UserDTO userDTO3 = UserDTO.convertToUser(u3);
		repo.save(u1);
		repo.save(u2);
		repo.save(u3);
	}

}
