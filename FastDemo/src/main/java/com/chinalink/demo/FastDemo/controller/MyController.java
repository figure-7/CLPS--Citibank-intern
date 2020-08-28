package com.chinalink.demo.FastDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalink.demo.FastDemo.entity.Student;
import com.chinalink.demo.FastDemo.repository.StudentRepository;

@RestController
@RequestMapping("fastDemo")
public class MyController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Value("${application.message}")
	private String message;
	
	@RequestMapping("hello")
	public String sayHello() {
		return "Hello, this is the first springboot application.";
	}
	
	@RequestMapping("getProperties")
	public String getProperties() {
		return message;
	}
	
	@RequestMapping("findAllStudents")
	public String findAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		if(studentList == null || studentList.size() == 0) {
			return "获取学生列表失败...";
		} else {
			return "获取学生列表成功，共有学生" + studentList.size() + "人。";
		}
		
	}
}
