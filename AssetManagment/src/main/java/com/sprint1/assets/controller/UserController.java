package com.sprint1.assets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assets.exception.LoginException;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.User;
import com.sprint1.assets.service.UserService;

@RestController
@RequestMapping("/asset/user")
public class UserController {
	@Autowired
	UserService userService;
	//Creating User
	@PostMapping(path="/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User u1=userService.createUser(user);
		if(u1==null) {
			return new ResponseEntity("Sorry! user not created",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

	//View Users
	@GetMapping (path="/users")
	public ResponseEntity<List<User>> viewAllUsers() throws NotFoundException{
		List<User> userList=userService.viewUsers();
		if(userList.isEmpty())
		{
			return new ResponseEntity("Sorry! User not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	//Login In
	@GetMapping (path="/login/{userId}/{userpassword}")
	public String loginService(@PathVariable int userId, @PathVariable String userpassword) throws LoginException {
		
		
			return userService.loginService(userId,userpassword);	
		
	}
	//update User role
		@PutMapping(path="/updateUser/{userId}/{role}")
		public String updateUserRole(@PathVariable int userId, @PathVariable String role ) throws NotFoundException {
			userService.updateUser(userId, role); 
			 return "role is updated successfully";
				
			}
		//find user by id
		@GetMapping(path="/findUser/{userId}")
		public Optional<User> findUserById(@PathVariable int userId) throws NotFoundException{
			return userService.findUserById(userId);
			
		}
}
