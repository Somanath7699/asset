package com.sprint1.assets.service;

import java.util.List;
import java.util.Optional;

import com.sprint1.assets.exception.LoginException;
import com.sprint1.assets.exception.NotFoundException;
import com.sprint1.assets.model.User;


public interface UserService {
	public User createUser(User user);
	public List<User> viewUsers() throws NotFoundException;
	public String loginService(int userId, String userpassword) throws LoginException;
	public String  updateUser(int userId, String role) throws NotFoundException;
	public Optional<User> findUserById(int userId) throws NotFoundException;

}

