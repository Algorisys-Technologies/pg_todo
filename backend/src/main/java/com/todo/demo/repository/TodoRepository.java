package com.todo.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo.demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {
	
	
	@Query("select t from Todo t where t.userid=:userid")
	public List<Todo> findByApiId(@Param("userid") String userid);
}
