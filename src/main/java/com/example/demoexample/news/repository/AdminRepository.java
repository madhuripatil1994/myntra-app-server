package com.example.demoexample.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoexample.model.User;

@Repository
public interface AdminRepository extends MongoRepository<User, String> {

}
