package com.thinkitive.demo.security;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

public class KeycloakJwtAuthenticationConverter extends JwtAuthenticationConverter {

    public KeycloakJwtAuthenticationConverter() {
        setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
    }
}