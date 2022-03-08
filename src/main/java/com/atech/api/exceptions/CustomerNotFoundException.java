package com.atech.api.exceptions;

import java.io.Serializable;

public class CustomerNotFoundException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 4909919655141620774L;

	public CustomerNotFoundException() {
		super();
	
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}



}
