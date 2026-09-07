package com.thinkitive.demo.dto.request;

public class LoginDTORequest {

    private String username;
    private String password;

    public LoginDTORequest() {
        super();
    }

    public LoginDTORequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}