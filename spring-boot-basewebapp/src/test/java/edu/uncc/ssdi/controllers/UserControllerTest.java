package edu.uncc.ssdi.controllers;

import java.util.List;

import edu.uncc.ssdi.model.*;
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
import org.springframework.web.servlet.ModelAndView;

import edu.uncc.ssdi.model.UserTest;
import edu.uncc.ssdi.repositories.UserRepository;
import edu.uncc.ssdi.service.UserService;
import edu.uncc.ssdi.util.CustomErrorType;

@RestController
@RequestMapping("/")
public class UserControllerTest {

@Autowired
private UserRepository userRepository;
@Autowired
private	UserService userService; //Service which will do all data retrieval/manipulation work	
	
@RequestMapping(value="/adduser/", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody UserTest addNewUser ( @RequestParam String email , @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		System.out.println("Reached");
		UserTest u = new UserTest();
		
		u.setEmail(email);
		u.setPassword(password);
		userRepository.save(u);
		return u;
	}
	
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<UserTest>  getAllUsers () {
		
		return (List<UserTest>) userRepository.findAll();
		
	}
	

	@RequestMapping(value="/profile", method = RequestMethod.GET) // Map ONLY GET Requests
	public ModelAndView  getProfile () {
		System.out.println("Hello");
		 ModelAndView mv = new ModelAndView("zindex1");
	        
	       // mv.setVie("zindex1");
	        //mv.getModel().put("data", "Welcome home man");
			System.out.println(mv.getViewName());

	        return mv;
	}
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserTest>  getUser(@PathVariable("id") Long id) {
		//long userId=0;
	 //   userId=Long.parseLong(id);
	    
	    /*  
	    User user1 = new User();
	    user1.setEmail("anurag@gmail.com");
*/
	  
		UserTest user = userService.findById(id);
		
		return new ResponseEntity<UserTest>(user, HttpStatus.OK);
	}
	
	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserTest user) {
		
		UserTest currentUser = userService.findById(id);

		
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
		return new ResponseEntity<UserTest>(currentUser, HttpStatus.OK);
	}
	
}
