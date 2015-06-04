package com.railroad.exceptions;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class InputStringSameTownException extends InputStringInvalidException {

	public InputStringSameTownException(String message) {
		super(message);
	}
	
	public InputStringSameTownException(String message, Exception e) {
		super(message, e);
	}

}
