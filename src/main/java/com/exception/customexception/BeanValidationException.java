package com.exception.customexception;


public class BeanValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeanValidationException() {
		super();
	}
	
	public BeanValidationException(String message) {
		super(message);
	}
}
