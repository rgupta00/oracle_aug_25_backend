package com.productapp.dto;

import java.time.LocalDateTime;

public class ErrorMessageDto1 {
	private String errorMessage;
	private int statusCode;
	private String toContact; 
	private LocalDateTime timeStamp;
	public ErrorMessageDto1(String errorMessage, int statusCode, String toContact, LocalDateTime timeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.toContact = toContact;
		this.timeStamp = timeStamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ErrorMessageDto1 [errorMessage=" + errorMessage + ", statusCode=" + statusCode + ", toContact="
				+ toContact + ", timeStamp=" + timeStamp + "]";
	}
	
	

}
