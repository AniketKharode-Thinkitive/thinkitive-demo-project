package com.thinkitive.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurtiyConfig {
	@Autowired
	private JWTAuthenticationFilter  authenticationFilter;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean 	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth/login").permitAll()

				.requestMatchers("/api/branches/*/employees/**", "/api/branches/*/managers/*/employees")
				.hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")	
				
				.requestMatchers("/api/branches/**").hasAnyRole("ADMIN", "MANAGER")

				.requestMatchers("/api/users").permitAll().anyRequest().authenticated()
				) 
			 .exceptionHandling(exception -> exception
			            .authenticationEntryPoint(
			                (request, response, authException) -> {
			                    response.sendError(
			                        HttpServletResponse.SC_UNAUTHORIZED,
			                        "Unauthorized"
			                    );
			                }
			            )
			        )
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
}
