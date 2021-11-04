package com.example.rest.service;

import java.util.List;

import com.example.rest.entity.Post;
import com.example.rest.repository.PostRepo;
import com.example.rest.request.LikeDislikeRequest;
import com.example.rest.request.PostRequest;
import com.example.rest.response.LikeDislikeResponse;
import com.example.rest.response.LoginResponse;
import com.example.rest.response.PostResponse;
import com.example.rest.response.UserPostResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;


    public PostResponse addPostOfUser(PostRequest postRequest) {
        if(postRequest.getTitle().isEmpty() || postRequest.getContent().isEmpty()){
            return new PostResponse(HttpStatus.BAD_REQUEST,"Both feilds are mandatory",null);
        }else{
            Post post=new Post(postRequest.getTitle(),
              postRequest.getContent(),
              postRequest.getLikes(), 
              postRequest.getDislikes(), 
              postRequest.getUserId());
              postRepo.save(post);
              return new PostResponse(HttpStatus.OK,"Post added successfully !!!", post.getUserId());
        }
       
    }

    public UserPostResponse getAllPostOfUser(String userId){
        List<Post> postList=postRepo.findByUserId(userId);
        if(postList.isEmpty()){
            return new UserPostResponse(HttpStatus.BAD_REQUEST,"No Post Yet , Please add some !!",null,userId);
        }else{
            return new UserPostResponse(HttpStatus.OK,"Successfully fetched all post", postList, userId);
        }
    }
    public LikeDislikeResponse updateLikes(LikeDislikeRequest likeDislikeRequest){
        Post post=postRepo.findByIdAndUserId(likeDislikeRequest.getId(),likeDislikeRequest.getUserId());
        post.setLikes(post.getLikes()+1);
        postRepo.save(post);
        return new LikeDislikeResponse(HttpStatus.OK,"This post is being liked");
    }

    public LikeDislikeResponse updateDislike(LikeDislikeRequest likeDislikeRequest) {
        Post post=postRepo.findByIdAndUserId(likeDislikeRequest.getId(),likeDislikeRequest.getUserId());
        post.setDislikes(post.getDislikes()+1);
        postRepo.save(post);
        return new LikeDislikeResponse(HttpStatus.OK,"This post is being disliked");
    }

    public PostResponse deletPostById(String id){
        postRepo.deleteById(id);
        return new PostResponse(HttpStatus.OK,"Post deleted successfully",id);
    }
}
