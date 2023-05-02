package com.example.MongoDBTest.repositories;

import com.example.MongoDBTest.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String>{

}
