package com.clps.springmvc.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//XxxHandler用于处理请求的应用程序，代替Servlet，单例的。
@Controller
//@RequestMapping(value="/springmvc") //表示映射一个父路径
public class HelloWorldHandler {

	public HelloWorldHandler(){
		System.out.println("new HelloWorldHandler()对象");
	}
	
	//映射请求路径，与之前Sevlet配置的<url-pattern>配置含义一致
	//value属性：用于映射请求资源名称，请求路径中需要指定资源名称进行访问；表示映射一个子路径
	//如果类和方法上同时使用了@RequestMapping来映射路径，那么，路径中必须包含父路径和子路径。
	//method属性：用于指定处理请求的方式。默认是可以处理get和post
	@RequestMapping(value="/helloworld",method=RequestMethod.GET) 
	public String helloworld(){
		System.out.println("helloworld....");
		return "success"; //    /WEB-INF/views + success + .jsp
	}
	
	
	
	
	@Autowired
	private ResourceBundleMessageSource messageSource; //从IOC容器中获取bean对象，进行依赖注入

	@RequestMapping("/testI18N")
	public String testI18N(Locale locale){
		
		String message = messageSource.getMessage("i18n.message", new Object[]{"郭靖","黄蓉"}, locale);
		System.out.println(message);
		
		System.out.println(locale);
		return "redirect:/testI18N2";
	}
	
}
