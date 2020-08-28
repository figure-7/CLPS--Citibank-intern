package com.chinalink.demo.fastclient.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalink.demo.fastclient.entity.User;
import com.chinalink.demo.fastclient.repository.UserRepository;

@RestController
@RequestMapping("/student")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Value("${server.port}")
    private String port;
	
    @GetMapping("/index")
    public String index(){
        return "当前端口："+this.port;
    }

	@GetMapping("/findAll")
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id") Long id) {
		User user = userRepository.findById(id);
		return user;
	}

	@PostMapping("/save")
	public Collection<User> save(@RequestBody User user) {
		userRepository.saveOrUpdate(user);
		return userRepository.findAll();
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userRepository.saveOrUpdate(user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
}
