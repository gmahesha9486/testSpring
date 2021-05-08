package com.telusko.secureapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
}
