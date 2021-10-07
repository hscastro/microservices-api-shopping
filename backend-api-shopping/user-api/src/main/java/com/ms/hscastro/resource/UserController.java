package com.ms.hscastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hscastro.entities.User;
import com.ms.hscastro.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return ResponseEntity.ok(newUser);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> listAllUsers() {
		List<User> lista = userService.listAllUser();
		return ResponseEntity.ok(lista);
	}
	
}
