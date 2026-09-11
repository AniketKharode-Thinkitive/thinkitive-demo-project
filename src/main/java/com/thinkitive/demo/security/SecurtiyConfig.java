package com.thinkitive.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurtiyConfig {

	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(auth -> auth

						.requestMatchers("/auth/login").permitAll()

						.requestMatchers("/api/branches/*/employees/**", "/api/branches/*/managers/*/employees")
						.hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")

						.requestMatchers("/api/branches/**").hasAnyRole("ADMIN", "MANAGER")

						.requestMatchers("/api/users").hasRole("ADMIN")

						.anyRequest().authenticated())

//            .exceptionHandling(exception -> exception
//                .authenticationEntryPoint(
//                    (request, response, authException) -> {
//                        response.sendError(
//                            HttpServletResponse.SC_UNAUTHORIZED,
//                            "Unauthorized"
//                        );
//                    }
//                )
//            )
				.oauth2ResourceServer(oauth2 -> oauth2
					    .jwt(jwt -> jwt
					        .jwtAuthenticationConverter(
					            new KeycloakJwtAuthenticationConverter()
					        )
					    )
					);	

		return http.build();
	}
}