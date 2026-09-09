package com.thinkitive.demo.exception.customexception;

public class ResourceDoesNotMatchException extends RuntimeException {

	public ResourceDoesNotMatchException(String message) {
		super(message);
	}
	
}
