package com.example.rest.response;

import org.springframework.http.HttpStatus;

public class LikeDislikeResponse {
    private HttpStatus status;
    private String message;
    public LikeDislikeResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
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
    
    
}
