package com.test.hello.Demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.hello.Demo.entity.Adress;
import com.test.hello.Demo.entity.Student;

@RestController
@RequestMapping("helloworld")
public class HelloWorldController {

	@Value("${spring.application.name}")
	private String appName;
	
	@RequestMapping("sayHi")
	public String sayHi() {
		return "Hellow, World !!!!!!";
	}
	
	@RequestMapping("student")
	public Student getStudent() {
		Student stu = new Student();
		stu.setAge(20);
		stu.setName("tom");
		stu.setScore(95.4);
		
		Adress add = new Adress();
		add.setCiti("dalian");
		add.setStreet("xxxx-yyyy-1982");
		
		stu.setAddress(add);
		return stu;
	}
	
	@RequestMapping("message")
	public String getMessage() {
		return appName;
	}
}
