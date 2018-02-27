package edu.uncc.ssdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="DOCTOR")
public class Doctor{
 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
 
	@Column(name="name")
	String name; 
	
	@Column(name="organization")
	String organization; 
 
	@Column(name="email")
	String email;
 
	public Doctor() {
		super();
	}
	public Doctor(String name,String organization, String email) {
		super();
		this.name=name;
		this.organization = organization;
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
