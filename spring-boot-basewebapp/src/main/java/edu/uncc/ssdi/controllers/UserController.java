package edu.uncc.ssdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.UserRepository;
import edu.uncc.ssdi.service.UserService;
import edu.uncc.ssdi.util.CustomErrorType;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
private UserRepository userRepository;
private	UserService userService; //Service which will do all data retrieval/manipulation work	
	
@RequestMapping(value="/addUser", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody String addNewUser ( @RequestParam String email , @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		System.out.println("Reached");
		User u = new User();
		
		u.setEmail(email);
		u.setPassword(password);
		userRepository.save(u);
		return "Saved";
	}
	
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<User>  getAllUsers () {
		
		return (List<User>) userRepository.findAll();
		
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") String id) {
		User user = userService.findByName(id);
		if (user == null) {
			
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		
		User currentUser = userService.findById(id);

		
		if (currentUser == null) {
			return new ResponseEntity<Object>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setAddressLine1(user.getAddressLine2());
		currentUser.setAddressLine1(user.getAddressLine2());
		currentUser.setDob(user.getDob());
		currentUser.setEmail(user.getEmail());
		currentUser.setGender(user.getGender());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhone(user.getPhone());
		currentUser.setPassword(user.getPassword());
		
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
}
