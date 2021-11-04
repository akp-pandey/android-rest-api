package com.example.rest.service;

import com.example.rest.entity.User;
import com.example.rest.repository.UserRepo;
import com.example.rest.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired 
    UserRepo userRepo;

    public String registerUser(User user){
        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            return "Password and Confirm Password should be same";
        }else{
            userRepo.save(user);
            return "Account created successfully !!";
        }
    }

    public LoginResponse loginUser(String emailId,String password){
        User user=userRepo.findByEmailIdAndPassword(emailId, password);
        if(user!=null){
            return new LoginResponse(HttpStatus.OK,"Successfully Login !!", user);
        }else{
            return new LoginResponse(HttpStatus.BAD_REQUEST,"Please enter valid credentials", user);
        }
    }

    public Boolean checkForExistingAccount(String emailId){
        User user=userRepo.findByEmailId(emailId);
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public LoginResponse deleteUserById(String id) {
        userRepo.deleteById(id);
        return new LoginResponse(HttpStatus.OK,"Your account has been deleted",null);
        
    }
}
