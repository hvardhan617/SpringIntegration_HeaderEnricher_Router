package com.springIntegration.dynamic.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BeanValidator {
	
	@NotNull
	@Valid
	private Object object;
	
	private String exceptionMessage;
	
	public BeanValidator(String message,Customer object) {
		this.exceptionMessage=message;
		this.object=object;
	}

	public BeanValidator() {
		
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	
}
