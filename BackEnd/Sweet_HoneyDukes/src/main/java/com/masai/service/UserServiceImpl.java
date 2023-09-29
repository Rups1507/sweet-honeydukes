package com.masai.service;

import java.util.List;

import com.masai.model.User;

@Service
@Slf4j
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepo userRepo;


	
@Override
public User addUser(User user) {
    try {
        if (user == null) {
            throw new IllegalArgumentException("User should not be null");
        }

        log.debug("Calling save method from UserJpa Repository");
        User savedUser = userRepo.save(user);
        log.info("User saved successfully");
        return savedUser;
    } catch (Exception e) {
        log.error("Error " + e.getMessage());
        throw new UserException("Failed to add user");
    }
}


@Override
public User updateExistingUser(User user) {
    log.debug("Calling findById method from UserJpa Repository");
    Optional<User> optionalUser = userRepo.findById(user.getUserId());

    if (optionalUser.isPresent()) {
        log.debug("Calling save method from UserJpa Repository");
        log.info("User updated successfully");

        User existingUser = optionalUser.get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepo.save(existingUser);
    } else {
        throw new UserException("User not found");
    }
}


	@Override
public String CancelUser(Integer userId) {
    log.debug("Calling findbyid method from UserJpa Repository");
    
    User userToDelete = userRepo.findById(userId)
            .orElseThrow(() -> new UserException("User not Exist"));
    
    log.debug("Calling delete method from UserJpa Repository");
    userRepo.delete(userToDelete);
    
    log.info("User deleted successfully");
    
    return "User Deleted";
}


	@Override
public List<User> ShowAllUser() {
    List<User> allUser = userRepo.findAll();
    if (!allUser.isEmpty()) {
        return allUser;
    } else {
        throw new UserException("User Not Found");
    }
}


	

}
