package com.thinkitive.demo.security;

import java.io.IOException;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private CustomeUserDetailService customeUserDetailService;
	
	String secretKey=	"mySecretKeyForThinkitiveProjectJwtAuthentication123456";

//	@Value("${jwt.secret}")
//	private String secretKey;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		  String authHeader = request.getHeader("Authorization");

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            filterChain.doFilter(request, response);
	            return;
	        }

	        String token = authHeader.substring(7);

	        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

	        Claims claims = Jwts.parser()
	                .verifyWith(key)
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();

	        String username = claims.getSubject();

	        UserDetails userDetails =
	                customeUserDetailService.loadUserByUsername(username);

	        UsernamePasswordAuthenticationToken authentication =
	                new UsernamePasswordAuthenticationToken(
	                        userDetails,
	                        null,
	                        userDetails.getAuthorities()
	                );

	        authentication.setDetails(
	                new WebAuthenticationDetailsSource()
	                        .buildDetails(request)
	        );

	        SecurityContextHolder.getContext()
	                .setAuthentication(authentication);

	        filterChain.doFilter(request, response);
		
	}

}
