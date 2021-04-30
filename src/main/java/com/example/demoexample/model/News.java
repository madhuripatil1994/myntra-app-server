package com.example.demoexample.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document(collection = "news")
@Data
public class News {

    @Id
    private String id;
    private  String title;
    
    @JsonProperty("image-url")
    private  String image_url;
    private  String description;
    private  String author;
    private  boolean published;
    
    public News() {
    	
    }

    public News(String title,String image_url, String description, String author, boolean published ) {
    	this.title = title;
        this.description = description;
        this.author = author;
        this.published = published;
        this.image_url = image_url;
    }

    public String getId() { return id; }

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isPublished() {
		return published;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setId(String id) {
		this.id = id;
	}

	
    
}