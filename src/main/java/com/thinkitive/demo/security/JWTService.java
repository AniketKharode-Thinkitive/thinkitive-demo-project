package com.thinkitive.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
//	@Value("${jwt.secret}")
//	private String secretKey;
//
//	@Value("${jwt.expiration}")
//	private long expiration;
	String secretKey="mySecretKeyForThinkitiveProjectJwtAuthentication123456";
    public String generateToken(String username) {

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .signWith(key)
                .compact();
    }
}
