package com.example.demoexample.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoexample.model.News;
import com.example.demoexample.news.repository.NewsRepository;

@RestController
@RequestMapping("/api")
public class NewsController {
	
	 private NewsRepository repository;

	    public NewsController(NewsRepository repository) {
	        this.repository = repository;
	    }
	    
	    @PostMapping(
	    value = "/",
	    consumes = {MediaType.APPLICATION_JSON_VALUE},
	    produces = {MediaType.APPLICATION_JSON_VALUE})
	    public News createNews(@RequestBody News news) {
	    	news.setId(ObjectId.get().toString());
	    	repository.save(news);
	        return news;
	    }

	    @GetMapping("/news")
	    public List<News> getAllNews(Model model) {
	    	List <News> ls = repository.findAll();
	        return ls;
	    }
	    
	    @PutMapping("/{id}")
	    public News updateNews(@PathVariable("id") ObjectId id, @RequestBody News news) {
	    	news.setId(id.toString());
	    	repository.save(news);
	    	return news;
	    }
	    
	    @DeleteMapping("/{id}")
	    public String deleteNews(@PathVariable("id") ObjectId id) {
	    	repository.deleteById(id.toString());
	    	return "Deleted successfullly";
	    }
	    
	    /*@GetMapping("/search/{filter}")
	    public News search(@PathVariable("title")String title) {
	    	repository.update
	    	return null;
	    }*/
	    
	    /*@PutMapping("/{id}/{publish}")
	    public String updatePublish(@PathVariable("id") ObjectId id,@PathVariable("publish")boolean published) {
	    	Query query1 = new Query(Criteria.where("id").is(id));
            Update update1 = new Update();
            update1.set("published", published);
            repository.updateFirst(query1, update1, News.class);
	    	return "Success";
	    }*/
	    
	    @GetMapping("/{title}")
	    public News getNewsByTitle(@PathVariable("title")String tt) {
	    	System.out.println("**"+ tt);
	    	News news = repository.findByTitle(tt);
	        return news;
	    }
}
