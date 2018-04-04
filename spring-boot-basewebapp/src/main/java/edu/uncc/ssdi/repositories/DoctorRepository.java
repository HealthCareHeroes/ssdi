package edu.uncc.ssdi.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.uncc.ssdi.model.Login;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DoctorRepository extends CrudRepository<Login, Long> {

}
