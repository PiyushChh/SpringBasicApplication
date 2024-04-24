package com.piyush.ui.userService;

import com.piyush.ui.model.request.UserDetailsRequestModel;
import com.piyush.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
