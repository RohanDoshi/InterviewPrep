package com.railroad.exceptions;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class NoSuchTownExistsException extends RuntimeException {

	public NoSuchTownExistsException(String message) {
		super(message);
	}
}
