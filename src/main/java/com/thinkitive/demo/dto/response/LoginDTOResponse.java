package com.thinkitive.demo.dto.response;

public class LoginDTOResponse {

    private String token;

    public LoginDTOResponse() {
        super();
    }

    public LoginDTOResponse(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}