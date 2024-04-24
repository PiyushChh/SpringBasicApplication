package com.piyush.ui.userService.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.ui.model.request.UserDetailsRequestModel;
import com.piyush.ui.model.response.UserRest;
import com.piyush.ui.shared.Utils;
import com.piyush.ui.userService.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils=utils;
	}
	
	Map<String,UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		
		
		userDetails.setFirstName(userDetails.getFirstName());
		
		UserRest returnValue=new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		
		String userId=utils.generateUserId();
		returnValue.setUserId(userId);
		if(users==null) users=new HashMap<>();
		
		
		users.put(userId, returnValue);
		
		return returnValue;
		
		
	}

}
