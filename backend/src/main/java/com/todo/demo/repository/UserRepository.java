package com.todo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todo.demo.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u where u.email =:email and u.password =:password")
	public Optional<User> login(@Param("email") String email, @Param("password") String password);

	@Query("select u from User u where u.name =:name")
	 User findByUsername(@Param("name") String name);
	
	@Query("select u from User u where u.email =:email")
	 User findByEmail(@Param("email") String email);
	
}
