package edu.uncc.ssdi.service;



import java.util.List;

import edu.uncc.ssdi.model.UserTest;

public interface UserService {
	
	UserTest findById(Long id);

	UserTest findByEmail(String name);

	void saveUser(UserTest user);

	void updateUser(UserTest user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<UserTest> findAllUsers();

	boolean isUserExist(UserTest user);
}