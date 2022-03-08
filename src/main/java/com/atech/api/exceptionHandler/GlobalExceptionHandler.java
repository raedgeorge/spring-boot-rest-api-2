package com.atech.api.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atech.api.exceptions.CustomerNotFoundException;
import com.atech.api.responseentity.CustomerErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception){
		
		CustomerErrorResponse response = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
