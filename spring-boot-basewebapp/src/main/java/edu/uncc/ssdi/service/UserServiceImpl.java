package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.UserTest;
import edu.uncc.ssdi.repositories.UserRepository;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public UserTest findById(Long id) {
		return userRepository.findOne(id);
	}


	public void saveUser(UserTest user) {
		userRepository.save(user);
	}

	public void updateUser(UserTest user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<UserTest> findAllUsers(){
		return (List<UserTest>) userRepository.findAll();
	}

	public boolean isUserExist(UserTest user) {
		return findByEmail(user.getFirstName()) != null;
	}


	@Override
	public UserTest findByEmail(String name) {
		return userRepository.findByEmail(name);
	}




}
