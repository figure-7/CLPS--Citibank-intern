package com.clps.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//自定义拦截器开发.
public class SecondInterceptor implements HandlerInterceptor {

	public SecondInterceptor() {
		System.out.println("创建了SecondInterceptor对象");
	}
	
	//在JSP执行渲染后执行功能扩展
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println(this.getClass().getName() + " - afterCompletion");
	}

	//在目标方法后执行功能扩展
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println(this.getClass().getName() + " - postHandle");
	}

	//在目标方法前执行功能扩展
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println(this.getClass().getName() + " - preHandle");
		//处理静态资源处理器
		//org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler
		return true;
	}

}
