package com.railroad.exceptions;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class InputStringInvalidException extends RuntimeException {

	public InputStringInvalidException(String message) {
		super(message);
	}
	
	public InputStringInvalidException(String message, Exception e) {
		super(message, e);
	}
}
