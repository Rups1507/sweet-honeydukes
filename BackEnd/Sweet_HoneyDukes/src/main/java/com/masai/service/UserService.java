package com.masai.service;

import java.util.List;

import com.masai.model.User;

public interface UserService {
	public User addUser(User user);
	public User updateUser(User user);
	public User cancelUser(Integer userId);
	public List<User> showAllUser();

	
}
