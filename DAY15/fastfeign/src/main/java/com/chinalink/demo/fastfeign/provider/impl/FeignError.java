package com.chinalink.demo.fastfeign.provider.impl;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.chinalink.demo.fastclient.entity.User;
import com.chinalink.demo.fastfeign.provider.FeignProviderClient;

@Component
public class FeignError implements FeignProviderClient {

	@Override
	public String index() {
		return "很抱歉，服务器还在维护中....";
	}

	@Override
	public Collection<User> findAll() {
		return null;
	}

	@Override
	public User findById(long id) {
		return null;
	}

	@Override
	public void save(User student) {

	}

	@Override
	public void update(User student) {

	}

	@Override
	public void deleteById(long id) {

	}

}
