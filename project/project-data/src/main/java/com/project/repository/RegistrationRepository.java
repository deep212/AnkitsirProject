package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Registration;

@Repository
public interface RegistrationRepository extends	JpaRepository<Registration, Integer> {

	
	
	
	@Query("select registration from Registration registration where registration.email=:email")
	 public Registration findByUserNameAndPass(@Param("email")String email);

	
	
}
