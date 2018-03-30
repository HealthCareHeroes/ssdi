package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.UserRepository;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		return userRepository.findOne(id);
	}


	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return (List<User>) userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByEmail(user.getFirstName()) != null;
	}


	@Override
	public User findByEmail(String name) {
		return userRepository.findByEmail(name);
	}




}
