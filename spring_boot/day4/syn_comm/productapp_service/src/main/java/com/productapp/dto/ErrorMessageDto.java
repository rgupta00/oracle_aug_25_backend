package com.productapp.dto;

import java.time.LocalDateTime;

public record ErrorMessageDto(String errorMessage, 
		int statusCode, 
		String toContact, 
		LocalDateTime timeStamp) 
{
}