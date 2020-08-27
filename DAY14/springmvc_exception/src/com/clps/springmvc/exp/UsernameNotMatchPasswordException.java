package com.clps.springmvc.exp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//自定义异常
@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="用户名称和密码不匹配!")
public class UsernameNotMatchPasswordException extends RuntimeException {

	public UsernameNotMatchPasswordException() {
	}

	public UsernameNotMatchPasswordException(String message) {
		super(message);
	}

}
