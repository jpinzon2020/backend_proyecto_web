package com.poli.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poli.project.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Spring Data Derived findBy Query Methods
	//Retrieve all records from the database based on the UserName
	//https://www.websparrow.org/spring/spring-data-derived-findby-query-methods-example
	User findByUserName(String userName);
}
