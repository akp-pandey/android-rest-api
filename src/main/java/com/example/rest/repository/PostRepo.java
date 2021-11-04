package com.example.rest.repository;

import java.util.List;

import com.example.rest.entity.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends MongoRepository<Post,String> {
    List<Post> findByUserId(String userId);
    Post findByIdAndUserId(String id,String userId);
}
