package com.thinkitive.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.UserDTORequest;
import com.thinkitive.demo.dto.response.StandardResponse;
import com.thinkitive.demo.dto.response.UserResponseDTO;
import com.thinkitive.demo.service.UserServiceImpl;
import com.thinkitive.demo.util.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	public ResponseEntity<StandardResponse> create(@RequestBody UserDTORequest request, HttpServletRequest httpServletRequest) {

		String requestId = UUID.randomUUID().toString();
		String path = httpServletRequest.getRequestURI();
		 UserResponseDTO userResponseDTO = userService.create(request);
		 StandardResponse suceess = StandardResponse.suceess(requestId, "User Created Successfully",  ResponseStatus.CREATED, path);
		 return new ResponseEntity<StandardResponse>(suceess,HttpStatus.CREATED);
	}
}