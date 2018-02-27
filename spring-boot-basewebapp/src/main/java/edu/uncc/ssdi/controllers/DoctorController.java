package edu.uncc.ssdi.controllers;

import java.util.List;

import edu.uncc.ssdi.model.Doctor;
import edu.uncc.ssdi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class DoctorController {
 
	@Autowired
	DoctorService doctorService;
 
	@RequestMapping(value = "/getAllDoctors", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Doctor> getAllDoctors(Model model) {
 
		List<Doctor> listOfDoctors = doctorService.getAllDoctors();
		model.addAttribute("Doctor", new Doctor());
		model.addAttribute("listOfDoctors", listOfDoctors);
		return listOfDoctors;
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllDoctors";
	}
 
	@RequestMapping(value = "/getDoctor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getDoctorById(@PathVariable int id) {
		System.out.println("Hello");
		doctorService.getDoctor(id);
	}
 
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST, headers = "Accept=application/json")
	public Doctor addDoctor(@RequestBody Doctor Doctor) {
		return doctorService.addDoctor(Doctor);
 
	}
 
	@RequestMapping(value = "/addDoctor", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Doctor updateDoctor(@RequestBody Doctor Doctor) {
		return doctorService.updateDoctor(Doctor); 
 
	}	
 
	@RequestMapping(value = "/deleteDoctor/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteDoctor(@PathVariable("id") int id) {
		doctorService.deleteDoctor(id);
 
 
	}	
}