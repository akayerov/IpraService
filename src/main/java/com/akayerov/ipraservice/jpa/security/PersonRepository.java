package com.akayerov.ipraservice.jpa.security;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface PersonRepository extends JpaRepository<Person, Integer> {
//	   List<Person> findByFirstNameLike(String firstName);
//	   List<Person> findByFirstNameLike(@Param("firstName") String firstName);
	   
	   @Override
	   @PreAuthorize("hasRole('ROLE_ADMIN')")
	   Page<Person> findAll(Pageable pageable);
	   @Override
	   @PostAuthorize("returnObject.firstName == principal.username or hasRole('ROLE_ADMIN')")
	   Person findOne(Integer aInt);
	   @PreAuthorize("hasRole('ROLE_ADMIN')")
	   List<Person> findByNameLike(@Param("name") String name);
	   
	}