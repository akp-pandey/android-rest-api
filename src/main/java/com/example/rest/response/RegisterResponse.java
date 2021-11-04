package com.example.rest.response;

import com.example.rest.entity.User;

import org.springframework.http.HttpStatus;

public class RegisterResponse {
    private HttpStatus status;
    private String message;
    private User user;
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public RegisterResponse(HttpStatus status, String message, User user) {
        this.status = status;
        this.message = message;
        this.user = user;
    }
    

}
