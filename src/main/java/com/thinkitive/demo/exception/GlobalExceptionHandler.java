package com.thinkitive.demo.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.exception.customexception.ResourceDoesNotMatchException;
import com.thinkitive.demo.exception.customexception.ResourceNotFoundException;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardResponse> handleResourceNotFoundEntity(ResourceNotFoundException ex , HttpServletRequest httpServletRequest){
		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();
		StandardResponse error = StandardResponse.error(requestId, ex.getMessage(), ResponseStatus.NOT_FOUND, path);
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceDoesNotMatchException.class)
	public ResponseEntity<StandardResponse> handleResourceDoesNotMatchException(ResourceDoesNotMatchException ex , HttpServletRequest httpServletRequest){
		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();
		StandardResponse error = StandardResponse.error(requestId, ex.getMessage(), ResponseStatus.BAD_REQUEST, path);
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardResponse> handleException(Exception ex , HttpServletRequest httpServletRequest){
		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();
		StandardResponse error = StandardResponse.error(requestId, "Something unexpected occured", ResponseStatus.INTERNAL_SERVER_ERROR, path);
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
