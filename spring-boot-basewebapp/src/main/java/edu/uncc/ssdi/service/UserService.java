package edu.uncc.ssdi.service;



import java.util.List;

import edu.uncc.ssdi.model.User;

public interface UserService {
	
	User findById(Long id);

	User findByEmail(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);
}