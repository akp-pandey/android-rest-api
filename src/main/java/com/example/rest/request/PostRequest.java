package com.example.rest.request;

public class PostRequest {
    private String title;
    private String content;
    private int likes;
    private int dislikes;
    private String userId;
    public PostRequest(String title, String content, int likes, int dislikes, String userId) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getDislikes() {
        return dislikes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
