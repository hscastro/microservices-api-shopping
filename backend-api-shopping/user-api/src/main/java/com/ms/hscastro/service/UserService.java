package com.ms.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hscastro.dto.UserDTO;
import com.ms.hscastro.entities.User;
import com.ms.hscastro.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDTO saveUser(UserDTO userDTO) {
		UserDTO newUserDTO = UserDTO.convertToUser(
				userRepository.save(User.convertToDTO(userDTO)));
		return newUserDTO;
	}

	public List<User> listAllUser() {
		List<User> lista = userRepository.findAll(); 
		return lista;
	}
	
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).get();
		return UserDTO.convertToUser(user);		
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		return UserDTO.convertToUser(user);			
	}

}
