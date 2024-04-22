package com.piyush.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUser(@RequestParam(value="page",defaultValue = "1") int page,@RequestParam(value="limit",defaultValue="50") int limit) {
		
		return "get User was called with page= "+page;
	}
	
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
		
		UserRest returnValue=new UserRest();
		returnValue.setFirstName("Piyush");
		returnValue.setLastName("Chh");
		returnValue.setEmail("p@gmail.com");
		returnValue.setUserId(userId);
		
		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
		
//		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
		
		
		
		
	}
	
	@PostMapping
	public String createUser() {
		return "Create user called";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user called";
		
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete User was called";
	}
	
}
