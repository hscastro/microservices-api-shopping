package com.ms.hscastro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hscastro.dto.UserDTO;
import com.ms.hscastro.entities.User;
import com.ms.hscastro.repositories.UserRepository;

@Service @Transactional(readOnly = false)
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDTO saveUser(UserDTO userDTO) {
		UserDTO newUserDTO = UserDTO.convertToUser(
				userRepository.save(User.convertToDTO(userDTO)));
		return newUserDTO;
	}

	@Transactional(readOnly = true)
	public List<UserDTO> listAllUser() {
		List<User> lista = userRepository.findAll(); 
		
		return lista
				.stream().map(UserDTO::convertToUser)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return UserDTO.convertToUser(user.get());
		}		
		return null;
	}
	
	@Transactional(readOnly = true)
	public UserDTO findUserByCpf(String cpf) {
		Optional<User> user = userRepository.findByCpf(cpf);
		if(user.isPresent()) {
			return UserDTO.convertToUser(user.get());
		}		
		return null;		
	}
		
	public UserDTO deleteUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return UserDTO.convertToUser(user.get());
		}		
		return null;
	}

}
