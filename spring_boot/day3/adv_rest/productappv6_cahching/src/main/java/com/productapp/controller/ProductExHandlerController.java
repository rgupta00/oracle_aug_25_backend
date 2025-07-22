package com.productapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorMessageDto;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice //all ex handing is done?
public class ProductExHandlerController {

	public ProductExHandlerController() {}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessageDto> handle404(ProductNotFoundException ex) {
		ErrorMessageDto dto=new ErrorMessageDto
				(ex.getMessage(), 404, "raj@oracle.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessageDto> handle400(MethodArgumentNotValidException ex) {
		
		String errorMessage=ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(e-> e.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
					
		ErrorMessageDto dto=new ErrorMessageDto
				(errorMessage, 400, "raj@oracle.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessageDto> handle500(Exception ex) {
		ErrorMessageDto dto=new ErrorMessageDto(ex.getMessage(), 500, "raj@oracle.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}
}
