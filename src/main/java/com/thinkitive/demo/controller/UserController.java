package com.thinkitive.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.UserDTORequest;
import com.thinkitive.demo.dto.response.UserResponseDTO;
import com.thinkitive.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	public UserResponseDTO create(@RequestBody UserDTORequest request) {

		return userService.create(request);
	}
}