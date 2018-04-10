package edu.uncc.ssdi.controllers;

import edu.uncc.ssdi.service.*;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;
import edu.uncc.ssdi.model.*;
import edu.uncc.ssdi.repositories.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserControllerTest1 {
	
		@Autowired
		private MockMvc mockMvc;

	    @InjectMocks
	    private UserController userController = new UserController();
	    
	    @Mock
	    private UserService userService;
	    
	    @Autowired
	    UserRepository userRepository;
	   
	    
	 // This object will be magically initialized by the initFields method below.
	    private JacksonTester<User> JsonUser;
	 
	    @Before
	    public void setup1() {
	        // Initializes the JacksonTester
	        JacksonTester.initFields(this, new ObjectMapper());
	    }
	    
	    @Before
	    public void setup() {
	 
	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);

	        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	 
	    }
	    
	    public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    @Test
		public void testAddUser() throws Exception{  	
	    	
			mockMvc.perform(MockMvcRequestBuilders.post("/adduser/")
					.contentType(MediaType.APPLICATION_JSON)
					.param("email", "abc@test.com")
					.param("password", "pwd123")
					.param("firstName", "Zoe")
					.param("lastName", "Duan")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());			
			
		}
	    	    
	    
	    @Test
	    public void testUpdateUser() throws Exception {
	        User user = new User(10002L, "mpq@test.com", "pwd123", "patient", "Zoe", "Duan","male", "20", "9201", "APT315", "Charlotte", "NC", "28223", "704123456");
	        when(userService.findById(user.getId())).thenReturn(user);
	        doNothing().when(userService).updateUser(user);
	       
	        mockMvc.perform(
	                put("/updateUser/{id}", user.getId())
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(asJsonString(user)))
	                .andExpect(status().isOk());
	        verify(userService, times(1)).findById(user.getId());
	        verify(userService, times(1)).updateUser(user);
	        verifyNoMoreInteractions(userService);
	    }
	    
	    
	   @Test
	    public void testGetAllUsers() throws Exception {
	    		ArrayList<User> expected = new ArrayList<User>();
	    			expected.add(new User(10002L, "mpq@test.com", "pwd123", "doctor", "Zoe", "Duan","male", "20", "9201", "APT315", "Charlotte", "NC", "28223", "704123456"));
	    			expected.add(new User(10003L, "abc@test.com", "pwd123", "doctor", "Joe", "Smith","male", "20", "9201", "APT315", "Charlotte", "NC", "28223", "704123456"));
	        
	    			when(userService.findAllUsers()).thenReturn(expected);

	       
	        mockMvc.perform(get("/getUsers"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(jsonPath("$[0].id", is(10002)))
	                .andExpect(jsonPath("$[0].email", is("mpq@test.com")))
	                .andExpect(jsonPath("$[1].id", is(10003)))
	                .andExpect(jsonPath("$[1].role", is("doctor")));
	        verify(userService, times(1)).findAllUsers();
	        verifyNoMoreInteractions(userService);
	    }
	
}
