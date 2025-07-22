package com.productapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorMessageDto;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ProductExHandlerController {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessageDto> handle404(ProductNotFoundException ex) {
		ErrorMessageDto dto=new ErrorMessageDto(ex.getMessage(), 404, "raj@oracle.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessageDto> handle500(Exception ex) {
		ErrorMessageDto dto=new ErrorMessageDto(ex.getMessage(), 500, "raj@oracle.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}
}
