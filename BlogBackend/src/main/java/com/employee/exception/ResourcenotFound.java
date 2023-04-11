package com.employee.exception;

public class ResourcenotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourcenotFound(String message) {
		super(message);
	}
}
