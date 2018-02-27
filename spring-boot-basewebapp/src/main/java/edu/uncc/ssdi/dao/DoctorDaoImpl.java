package edu.uncc.ssdi.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.model.Doctor;
 
@Repository
public class DoctorDaoImpl implements DoctorDao{
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List<Doctor> getAllDoctors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Doctor>  DoctorList = session.createQuery("from Doctor").list();
		return DoctorList;
	}
 
	public Doctor getDoctor(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Doctor Doctor = (Doctor) session.get(Doctor.class, id);
		System.out.println("Name : " + Doctor.getName());
		return Doctor;
	}
 
	public Doctor addDoctor(Doctor Doctor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Doctor);
		return Doctor;
	}
 
	public void updateDoctor(Doctor Doctor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Doctor);
	}
 
	public void deleteDoctor(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Doctor p = (Doctor) session.load(Doctor.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
