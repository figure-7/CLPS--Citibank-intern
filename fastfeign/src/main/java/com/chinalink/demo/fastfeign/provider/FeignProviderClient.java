package com.chinalink.demo.fastfeign.provider;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chinalink.demo.fastclient.entity.User;
import com.chinalink.demo.fastfeign.provider.impl.FeignError;

@FeignClient(value = "fastclient", fallback = FeignError.class)
public interface FeignProviderClient {

	@GetMapping("/student/index")
	public String index();

	@GetMapping("/student/findAll")
	public Collection<User> findAll();

	@GetMapping("/student/findById/{id}")
	public User findById(@PathVariable("id") long id);

	@PostMapping("/student/save")
	public void save(@RequestBody User student);

	@PutMapping("/student/update")
	public void update(@RequestBody User student);

	@DeleteMapping("/student/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id);
}
