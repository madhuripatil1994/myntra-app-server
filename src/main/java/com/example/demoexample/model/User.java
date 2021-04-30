package com.example.demoexample.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
	
	@Id
    private String id;
	@JsonProperty("first_name")
	@NotNull(message = "First Name Shoud Not be Blank")
	private  String firstName;
	@JsonProperty("last_name")
	private  String lastName;
	@NotNull(message = "Email Shoud Not be Blank")
	@JsonProperty("email")
	private  String email;
	@NotNull(message = "Password Shoud Not be Blank")
	@JsonProperty("password")
	private  String password;
	
	public User() {
    	
    }

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	

}
