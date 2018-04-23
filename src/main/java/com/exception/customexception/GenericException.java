package com.exception.customexception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericException() {
		super();
	}
	
	public GenericException(String message) {
		super(message);
	}
}
