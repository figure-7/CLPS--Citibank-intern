package com.chinalink.demo.fastclient.repository;

import java.util.Collection;

import com.chinalink.demo.fastclient.entity.User;

public interface UserRepository {
	
	public Collection<User> findAll();
	public User findById(Long id);
	public void saveOrUpdate(User user);
	public void deleteById(Long id);
}
