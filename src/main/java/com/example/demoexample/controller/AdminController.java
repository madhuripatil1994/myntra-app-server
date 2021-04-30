package com.example.demoexample.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoexample.model.User;
import com.example.demoexample.news.repository.AdminRepository;

@RestController
@RequestMapping("/auth")
public class AdminController {
	
	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping(
		    value = "/",
		    consumes = {MediaType.APPLICATION_JSON_VALUE},
		    produces = {MediaType.APPLICATION_JSON_VALUE})
		    public String createNews(@RequestBody User user) {
				try {
					System.out.println(user.getLastName());
					user.setId(ObjectId.get().toString());
			    	System.out.println(repository.save(user));
			        return "success";
				}catch(Exception e) {
					return e.getMessage();
				}
				
		    }

}
