package edu.uncc.ssdi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @NotNull
    // need to specify that it must be unique
    @Column(unique=true)
	private String email;
    
    @NotNull
    private String password;
    
    @Column(nullable = true)
    private String role;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @Column(nullable = true)
    private Date dob;
    
    @Column(nullable = true)
    private String gender;
    
    @Column(nullable = true)
    private String addressLine1;
    
    @Column(nullable = true)
    private String addressLine2;
    
    @Column(nullable = true)
    private String city;
    
    @Column(nullable = true)
	private String state;
    
    @Column(nullable = true)
    private String zip;
    
    @Column(nullable = true)
    private String phone;
    
    public User() {
    	super();
    }
    
    public User(long id, String email, String password, String role, String firstName, String lastName, Date dob,
			String gender, String addressLine1, String addressLine2, String city, String state, String zip,
			String phone) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


   
}





