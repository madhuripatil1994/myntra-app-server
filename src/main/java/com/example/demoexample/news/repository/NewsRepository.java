package com.example.demoexample.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoexample.model.News;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {

	public News findByTitle(String title);
	
}
