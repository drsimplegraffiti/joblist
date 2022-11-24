package com.example.joblist;

import com.example.joblist.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


// MongoDBRepository is a Spring Data interface that provides CRUD operations
// for the specified entity (Collection) and id type (Primary Key).
public interface PostRepository extends MongoRepository<Post, String> {

}


