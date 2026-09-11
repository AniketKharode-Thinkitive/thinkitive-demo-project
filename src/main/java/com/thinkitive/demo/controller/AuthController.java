package com.thinkitive.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.demo.dto.request.LoginDTORequest;
import com.thinkitive.demo.dto.response.LoginDTOResponse;
import com.thinkitive.demo.security.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;	
//	@Autowired
//	private JWTService jwtService;
//    @PostMapping("/login")
//    public LoginDTOResponse login(@RequestBody LoginDTORequest request) {
//    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//    		String token = jwtService.generateToken(request.getUsername());
//    	return new LoginDTOResponse(token);
//    }
}