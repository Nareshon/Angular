package com.cognizant.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User already exists. Try another username")
public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
