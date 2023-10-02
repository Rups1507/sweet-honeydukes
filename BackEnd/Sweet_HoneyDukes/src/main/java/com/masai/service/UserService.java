package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.User;

public interface UserService {
	public User addUser(User user)throws NoRecordsFoundException;
	public User updateUser(User user)throws NoRecordsFoundException;
	public User cancelUser(Integer userId)throws NoRecordsFoundException;
	public List<User> showAllUser()throws NoRecordsFoundException;

	
}
