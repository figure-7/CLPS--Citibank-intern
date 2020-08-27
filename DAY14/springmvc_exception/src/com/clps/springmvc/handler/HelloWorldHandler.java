package com.clps.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.springmvc.exp.UsernameNotMatchPasswordException;

//XxxHandler用于处理请求的应用程序，代替Servlet，单例的。
@Controller
@RequestMapping(value="/springmvc") //表示映射一个父路径
public class HelloWorldHandler {

	public HelloWorldHandler(){
		System.out.println("new HelloWorldHandler()对象");
	}
	
//	@ExceptionHandler(value={java.lang.ArithmeticException.class})
//	public String handeException(){		
//		
//		return "error";
//	}
	
	
//	@ExceptionHandler(value={java.lang.Exception.class})
//	public String handeException2(){		
//		
//		return "error2";
//	}
	
	
	//映射请求路径，与之前Sevlet配置的<url-pattern>配置含义一致
	//value属性：用于映射请求资源名称，请求路径中需要指定资源名称进行访问；表示映射一个子路径
	//如果类和方法上同时使用了@RequestMapping来映射路径，那么，路径中必须包含父路径和子路径。
	//method属性：用于指定处理请求的方式。默认是可以处理get和post
	@RequestMapping(value="/helloworld",method=RequestMethod.GET) 
	public String helloworld(){
		//java.lang.ArithmeticException
//		throw new RuntimeException();
		int i = 1/0 ;
		
		System.out.println("helloworld....");
		return "success"; //    /WEB-INF/views + success + .jsp
	}
	
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") Integer i){
		
		if(i==13){
			throw new UsernameNotMatchPasswordException();
		}
		
		return "success";
	}
	
}
