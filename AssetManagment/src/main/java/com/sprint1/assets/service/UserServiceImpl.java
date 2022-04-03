package com.sprint1.assets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assets.exception.LoginException;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.User;
import com.sprint1.assets.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	int login=0;
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
		
	}
//
	@Override
	public List<User> viewUsers() throws NotFoundException
	{
		return userRepository.findAll();
	}

	public String updateUser(int userId, String role) throws NotFoundException
	{
	
				userRepository.updateUser(userId, role);
				return "Successfully updated";
	}

	@Override
	public Optional<User> findUserById(int userId) throws NotFoundException
	{
		return userRepository.findById(userId);
	}
	@Override
	public String loginService(int userId, String userpassword) throws LoginException
	{
	
	String password= userRepository.getPassword(userId);
	if(password.equals(userpassword)) {
	User user = userRepository.getById(userId);
	if(user.getRole().equalsIgnoreCase("user")) {
	System.out.println("Logged in as User");
	return user.getRole();
	}
	else if(user.getRole().equalsIgnoreCase("Admin")) {
		login=1;
	System.out.println("Logged in as Administrator");
	return user.getRole();
	}
	else if(user.getRole().equalsIgnoreCase("Manager")) {
	System.out.println("Logged in as Warehouse Manager");
	return user.getRole();
	}
	}
	return "Incorrect UserId or User Password";
	
	}
}

