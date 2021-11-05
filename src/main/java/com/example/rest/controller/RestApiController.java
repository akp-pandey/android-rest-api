package com.example.rest.controller;

import javax.validation.Valid;

import com.example.rest.entity.User;
import com.example.rest.request.DeleteRequest;
import com.example.rest.request.LikeDislikeRequest;
import com.example.rest.request.LoginRequest;
import com.example.rest.request.PostRequest;
import com.example.rest.request.RegisterRequest;
import com.example.rest.request.UserPostRequest;
import com.example.rest.response.LikeDislikeResponse;
import com.example.rest.response.LoginResponse;
import com.example.rest.response.PostResponse;
import com.example.rest.response.RegisterResponse;
import com.example.rest.response.UserPostResponse;
import com.example.rest.service.PostService;
import com.example.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/android/api")
public class RestApiController {
    
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @PostMapping("/register")
    public RegisterResponse registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        if(userService.checkForExistingAccount(registerRequest.getEmailId())){
            return new RegisterResponse(HttpStatus.BAD_REQUEST,"Account is already there with email id "+registerRequest.getEmailId(), null);
        }else{
            User user=new User(registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getEmailId(), registerRequest.getPassword(),registerRequest.getConfirmPassword());
            String message=userService.registerUser(user);
            if(message.equals("Password and Confirm Password should be same")){
                return new RegisterResponse(HttpStatus.BAD_REQUEST,message,user);
            }
            return new RegisterResponse(HttpStatus.OK,message,user);
        }
      
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest.getEmailId(), loginRequest.getPassword());
    }

    @PostMapping("/addPost")
    public PostResponse addPost(@RequestBody PostRequest postRequest){
        return postService.addPostOfUser(postRequest);
    }

    @GetMapping("/getPost/{userId}")
    public UserPostResponse getPost(@PathVariable String userId){
        return postService.getAllPostOfUser(userId);
    }

    @PatchMapping("/like")
    public LikeDislikeResponse likePost(@RequestBody LikeDislikeRequest likeDislikeRequest){
        return postService.updateLikes(likeDislikeRequest);
    }

    @PatchMapping("/dislike")
    public LikeDislikeResponse dislikePost(@RequestBody LikeDislikeRequest likeDislikeRequest){
        return postService.updateDislike(likeDislikeRequest);
    }

    @DeleteMapping("delete/post")
    public PostResponse deletePost(@RequestBody DeleteRequest deleteRequest){
       return postService.deletPostById(deleteRequest.getId());
    }
    @DeleteMapping("delete/user/")
    public LoginResponse deleteUser(@RequestBody DeleteRequest deleteRequest){
        return userService.deleteUserById(deleteRequest.getId());
    }


}
