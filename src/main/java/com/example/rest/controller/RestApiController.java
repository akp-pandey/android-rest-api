package com.example.rest.controller;

import javax.validation.Valid;

import com.example.rest.entity.User;
import com.example.rest.request.LoginRequest;
import com.example.rest.request.RegisterRequest;
import com.example.rest.response.LoginResponse;
import com.example.rest.response.RegisterResponse;
import com.example.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/android/api")
public class RestApiController {
    
    @Autowired
    UserService userService;

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


}
