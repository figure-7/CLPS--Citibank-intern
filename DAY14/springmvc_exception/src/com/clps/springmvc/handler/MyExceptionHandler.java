package com.clps.springmvc.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

//	@ExceptionHandler(value={java.lang.ArithmeticException.class})
//	@ExceptionHandler(value = { java.lang.Exception.class })
//	public ModelAndView handeException(Exception e) {  //处理异常的方法,不能使用Map作为入参
//
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("e", e);
//		
//		return mv;
//	}

}
