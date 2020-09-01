package com.mqslll.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mqslll.todo.entity.ToDoDetail;
import com.mqslll.todo.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public List<ToDoDetail> findAll() {
		return toDoRepository.findAll();
	}
	
	public ToDoDetail findById(String toDoId) {
		return toDoRepository.findById(toDoId).get();
	}
	
	public void saveToDo(ToDoDetail toDoDetail) {
		toDoRepository.save(toDoDetail);
	}
}
