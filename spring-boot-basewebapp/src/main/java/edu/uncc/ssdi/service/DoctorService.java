package edu.uncc.ssdi.service;


import java.util.List;
 
import javax.transaction.Transactional;
 
import edu.uncc.ssdi.dao.DoctorDao;
import edu.uncc.ssdi.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service("doctorService")
public class DoctorService {
 
	@Autowired
	DoctorDao DoctorDao;
 
	@Transactional
	public List<Doctor> getAllDoctors() {
		return DoctorDao.getAllDoctors();
	}
 
	@Transactional
	public Doctor getDoctor(int id) {
		return DoctorDao.getDoctor(id);
	}
 
	@Transactional
	public Doctor addDoctor(Doctor Doctor) {
		DoctorDao.addDoctor(Doctor);
		return Doctor;
	}
 
	@Transactional
	public Doctor updateDoctor(Doctor Doctor) {
		DoctorDao.updateDoctor(Doctor);
		return Doctor;
	}
 
	@Transactional
	public void deleteDoctor(int id) {
		DoctorDao.deleteDoctor(id);
	}
}