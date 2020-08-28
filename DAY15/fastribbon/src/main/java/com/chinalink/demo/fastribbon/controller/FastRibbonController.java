package com.chinalink.demo.fastribbon.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chinalink.demo.fastclient.entity.User;

@RequestMapping("/ribbon")
@RestController
public class FastRibbonController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://fastclient/student/index",String.class);
    }

	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return restTemplate.getForObject("http://fastclient/student/findAll", Collection.class);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") long id) {
		User user = restTemplate.getForObject("http://fastclient/student/findById/{id}", User.class, id);
		return user;
	}

	@PostMapping("/save")
	public void save(@RequestBody User student) {
		restTemplate.postForObject("http://fastclient/student/save", student, User.class);
	}

	@PutMapping("/update")
	public void update(@RequestBody User student) {
		restTemplate.put("http://fastclient/student/update", student);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		restTemplate.delete("http://fastclient/student/deleteById/{id}", id);
	}
}
