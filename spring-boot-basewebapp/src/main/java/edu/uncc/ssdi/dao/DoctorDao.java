package edu.uncc.ssdi.dao;

import java.util.List;

import edu.uncc.ssdi.model.Doctor;
 
public interface DoctorDao {
	public List<Doctor> getAllDoctors() ;
 
	public Doctor getDoctor(int id) ;
 
	public Doctor addDoctor(Doctor Doctor);
 
	public void updateDoctor(Doctor Doctor) ;
 
	public void deleteDoctor(int id) ;
}