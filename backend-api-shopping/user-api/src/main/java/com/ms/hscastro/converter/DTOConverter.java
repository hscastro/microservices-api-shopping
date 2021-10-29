package com.ms.hscastro.converter;

import com.ms.hscastro.dto.UserDTO;
import com.ms.hscastro.entities.User;


public class DTOConverter {
	
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());

		return userDTO;
	}
	
}
