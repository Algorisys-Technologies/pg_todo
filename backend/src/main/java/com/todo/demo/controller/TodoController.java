package com.todo.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.model.Todo;
import com.todo.demo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getTodos(@RequestHeader Map<String, String> headers) {
//		todoService.exceptionHandle(headers);
		return todoService.findAllTodo();
	}

	@GetMapping("/{id}")
	public Optional<Todo> getTodoById(@PathVariable String id) {		
		return todoService.findTodo(id);

	}

	@GetMapping("/id/{userid}")
	public List<Todo> getTodoByApiId(@PathVariable String userid) {	
		return todoService.findUserTodo(userid);
	}

	@PostMapping("/add")
	public Todo createTodo(@RequestBody Todo todo, @RequestHeader Map<String, String> headers) {
//		todoService.exceptionHandle(headers);
		return todoService.register(todo);
	}

	@DeleteMapping("/cancel/{id}")
	public List<Todo> deleteTodo(@PathVariable String id) {
		return todoService.cancelRegistration(id);
	}

	@PutMapping()
	public Todo editTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo);
	}

}
