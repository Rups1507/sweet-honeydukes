package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.User;
import com.masai.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;


	
@Override
public User addUser(User user) throws NoRecordsFoundException {
    try {
        if (user == null) {
            throw new NoRecordsFoundException("User should not be null");
        }else {
        User savedUser = userRepo.save(user);
        return savedUser;
    }
    }catch (Exception e) {
        throw new NoRecordsFoundException("Failed to add user");
    }
    }



@Override
public User updateUser(User user) throws NoRecordsFoundException{
    Optional<User> optionalUser = userRepo.findById(user.getUserId());
    if (optionalUser.isPresent()) {
        User existingUser = optionalUser.get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setEmail(user.getEmail());
        return userRepo.save(existingUser);
    } else {
        throw new NoRecordsFoundException("User not found");
    }
}


	@Override
	public User cancelUser(Integer userId) throws NoRecordsFoundException {
		Optional<User> op = userRepo.findById(userId);
		if(op.isPresent()) {
			userRepo.deleteById(userId);
			return op.get();
		}
		else {
			throw new NoRecordsFoundException("No userRepo available with userId: "+ userId);
		}
	}

	@Override
public List<User> showAllUser()throws NoRecordsFoundException {
    List<User> allUser = userRepo.findAll();
    if (!allUser.isEmpty()) {
        return allUser;
    } else {
        throw new NoRecordsFoundException("User Not Found");
    }
}


	

}
