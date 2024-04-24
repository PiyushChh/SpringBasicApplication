package com.piyush.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.ui.exceptions.UserServiceException;
import com.piyush.ui.model.request.UpdateUserDetailsRequestModel;
import com.piyush.ui.model.request.UserDetailsRequestModel;
import com.piyush.ui.model.response.UserRest;
import com.piyush.ui.userService.UserService;
import com.piyush.ui.userService.impl.UserServiceImpl;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String,UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser(@RequestParam(value="page",defaultValue = "1") int page,@RequestParam(value="limit",defaultValue="50") int limit) {
		
		return "get User was called with page= "+page;
	}
	
	
	@GetMapping(path="/{userId}",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
		
//		//To check exception
//		String s=null;
//		int length=s.length();
//		
//		if(true) throw new UserServiceException("String is null");

		if(users!=null && users.containsKey(userId)) {
			
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		

		
		
		
		
		
		
	}
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue=userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
		
	}
	
	@PutMapping(path="/{userId}",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRest updateUser(@PathVariable("userId") String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		
		UserRest storedUserDetails=users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId,storedUserDetails);
		
		return storedUserDetails;
		
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
	}
	
}
}
