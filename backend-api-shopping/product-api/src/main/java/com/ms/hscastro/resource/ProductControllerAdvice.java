package com.ms.hscastro.resource;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ms.hscastro.dto.ErrorDTO;
import com.ms.hscastro.exceptions.CategoryNotFoundException;
import com.ms.hscastro.exceptions.ProductNotFoundException;


@ControllerAdvice
public class ProductControllerAdvice {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Produto não encontrado.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CategoryNotFoundException.class)
	public ErrorDTO handleCategoryNotFound(CategoryNotFoundException categoryNotFoundException) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Categoria não encontrado.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
	
}