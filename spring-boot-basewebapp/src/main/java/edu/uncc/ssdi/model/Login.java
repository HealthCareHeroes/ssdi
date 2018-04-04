package edu.uncc.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Login {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String username;

    private String password;

    private int role;
    
 
	public String getUserName() {
    	return username;
    }
  public void setUserName(String username) {
	  this.username = username;
  }
    
  public String getPassword() {
	  return password;
  }
    
  public void setPassword(String password) {
	  this.password = password;
  }
  
  public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}

