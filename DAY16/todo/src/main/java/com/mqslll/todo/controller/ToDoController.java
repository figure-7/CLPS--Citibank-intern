package com.mqslll.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mqslll.todo.entity.ToDoDetail;
import com.mqslll.todo.service.ToDoService;

@RestController
@RequestMapping("toDoService")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	@GetMapping("/toDos")
	public List<ToDoDetail> getToDoList() {
		return toDoService.findAll();
	}
	
	@GetMapping("/toDo/{toDoId}")
	public ToDoDetail getToDo(@PathVariable("toDoId") String toDoId) {
		return toDoService.findById(toDoId);
	}
	
	@PostMapping("/toDo")
	public void addToDo(@RequestBody ToDoDetail toDoDetail) {
		toDoService.saveToDo(toDoDetail);
	}
}
