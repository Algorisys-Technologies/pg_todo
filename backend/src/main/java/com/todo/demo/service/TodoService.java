package com.todo.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todo.demo.model.Todo;
import com.todo.demo.repository.TodoRepository;

//import java.util.Map;
//import org.springframework.http.HttpStatus;
//import io.jsonwebtoken.ExpiredJwtException;
//import org.springframework.web.bind.annotation.RequestHeader;
//import com.todo.demo.config.JwtTokenUtil;
//import com.todo.demo.exception.ApplicationException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;

	public Todo register(Todo todo) {
		return todoRepo.save(todo);
	}

	public List<Todo> findAllTodo() {
		return todoRepo.findAll();
	}

	public Optional<Todo> findTodo(String id) {
		return todoRepo.findById(id);
	}

	public List<Todo> findUserTodo(String id) {
		return todoRepo.findByApiId(id);
	}

	public List<Todo> cancelRegistration(String id) {
		todoRepo.deleteById(id);
		return todoRepo.findByApiId(id);
	}

	public Todo updateTodo(Todo todo) {
		return todoRepo.save(todo);
	}
	
//	public void exceptionHandle(@RequestHeader Map<String, String> headers) {
//		String token = headers.get("authorization").substring(7).trim();
//		try {
//			jwtTokenUtil.validateToken(token);
//		}catch(ExpiredJwtException exception){
//			throw new ApplicationException("Token Expired", HttpStatus.UNAUTHORIZED);
//		}
//	}
}
