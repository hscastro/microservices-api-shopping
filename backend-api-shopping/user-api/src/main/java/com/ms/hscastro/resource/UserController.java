package com.ms.hscastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hscastro.dto.UserDTO;
import com.ms.hscastro.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		UserDTO newUser = userService.saveUser(userDTO);
		return ResponseEntity.ok(newUser);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UserDTO>> listAllUsers() {
		List<UserDTO> lista = userService.listAllUser();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
		UserDTO user = userService.findUserById(id);
		return ResponseEntity.ok(user);
	}

	@RequestMapping(value = "/users/{cpf}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UserDTO> getUserByCpf(@PathVariable("cpf") String cpf) {
		UserDTO user = userService.findUserByCpf(cpf);
		return ResponseEntity.ok(user);
	}
}
