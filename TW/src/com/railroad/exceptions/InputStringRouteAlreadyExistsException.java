package com.railroad.exceptions;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class InputStringRouteAlreadyExistsException extends InputStringInvalidException {

	public InputStringRouteAlreadyExistsException(String message) {
		super(message);
	}
	public InputStringRouteAlreadyExistsException(String message, Exception e) {
		super(message, e);
	}

}
