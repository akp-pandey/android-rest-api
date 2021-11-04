package com.example.rest.response;

import java.util.List;

import com.example.rest.entity.Post;

import org.springframework.http.HttpStatus;

public class UserPostResponse {
    private HttpStatus status;
    private String message;
    private List<Post> postList;
    private String userId;
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
    public List<Post> getPostList() {
        return postList;
    }
    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public UserPostResponse(HttpStatus status, String message, List<Post> postList, String userId) {
        this.status = status;
        this.message = message;
        this.postList = postList;
        this.userId = userId;
    }
    


}
