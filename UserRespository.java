package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.priyanka.model.User;

public interface UserRespository extends JpaRepository<User, Long> {
	@Query("Select user from User user where user.email=?1")
	User findbyemail(String email);
}
