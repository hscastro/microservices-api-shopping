package com.ms.hscastro.resource;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ms.hscastro.dto.ErrorDTO;
import com.ms.hscastro.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserControllerAdvice {

	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Usuário não encontrado.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
}
