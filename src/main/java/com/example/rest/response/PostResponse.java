package com.example.rest.response;

import org.springframework.http.HttpStatus;

public class PostResponse {
    private HttpStatus status;
    private String message;
    private String userId;
    public PostResponse(HttpStatus status, String message, String userId) {
        this.status = status;
        this.message = message;
        this.userId = userId;
    }
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
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
