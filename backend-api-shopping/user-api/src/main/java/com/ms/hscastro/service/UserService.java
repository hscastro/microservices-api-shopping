package com.ms.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hscastro.entities.User;
import com.ms.hscastro.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	public List<User> listAllUser() {
		return userRepository.findAll();
	}

}
