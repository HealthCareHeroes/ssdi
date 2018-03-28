package edu.uncc.ssdi.repositories;



import org.springframework.data.repository.CrudRepository;

import edu.uncc.ssdi.model.UserTest;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserTest, Long> {
	UserTest findByEmail(String email);
}

