package com.piyush.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUser() {
		
		return "get User was called";
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
