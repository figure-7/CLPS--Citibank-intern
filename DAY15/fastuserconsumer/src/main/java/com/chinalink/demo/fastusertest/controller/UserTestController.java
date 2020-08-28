package com.chinalink.demo.fastusertest.controller;

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

@RestController
@RequestMapping("usertest")
public class UserTestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return restTemplate.getForEntity("http://localhost:9002/student/findAll", Collection.class).getBody();
	}

	@GetMapping("/findAll2")
	public Collection<User> findAll2() {
		return restTemplate.getForObject("http://localhost:9002/user/findAll", Collection.class);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") Long id) {
		return restTemplate.getForEntity("http://localhost:9002/user/findById/{id}", User.class, id).getBody();
	}

	@GetMapping("/findById2/{id}")
	public User findById2(@PathVariable("id") Long id) {
		return restTemplate.getForObject("http://localhost:9002/user/findById/{id}", User.class, id);
	}

	@PostMapping("/save")
	public Collection<User> save(@RequestBody User user) {
		return restTemplate.postForEntity("http://localhost:9002/user/save", user, Collection.class).getBody();
	}

	@PostMapping("/save2")
	public Collection<User> save2(@RequestBody User user) {
		return restTemplate.postForObject("http://localhost:9002/user/save", user, Collection.class);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		restTemplate.put("http://localhost:9002/user/update", user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable("id") Long id) {
		restTemplate.delete("http://localhost:9002/user/deleteById/{id}", id);
	}
}
