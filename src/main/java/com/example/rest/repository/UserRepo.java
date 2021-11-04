package com.example.rest.repository;

import com.example.rest.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String>  {
    User findByEmailId(String emailId);
    User findByEmailIdAndPassword(String emailId,String password);
}
