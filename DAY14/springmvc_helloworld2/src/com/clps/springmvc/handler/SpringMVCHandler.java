package com.clps.springmvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.clps.springmvc.bean.User;

@Controller
@RequestMapping("/springmvc")
//value : 通过指定map中的key，将数据存放到session域中
//types: 通过指定map中存放数据的类型，将数据存放到session域中
//@SessionAttributes只能用于类上
//@SessionAttributes(value={"username"},types=User.class)//同时设置value和types表示或的关系
public class SpringMVCHandler {

	@RequestMapping(value="/helloworld",method=RequestMethod.GET)
//	@RequestMapping(value="/helloworld",
//					params={"username!=zhangsan","age!=10"},
//					headers={"Accept-Language!=en,zh-CN;q=0.9,zh;q=0.8,en-US;q=0.7,ja;q=0.6"})
	public String hello(){
		System.out.println("hello...");
		return "success";
	}
	
	//ant风格
	@RequestMapping(value="/*/helloworld")//** /a/b ? a?b
	public String hello2(){
		System.out.println("hello2...");
		return "success";
	}
	
	//使用大括号来匹配路径中传递值，{}表示站位符。站位符名称自定义。两端不能有空格。
	@RequestMapping(value="/testPathVariable/{id}/{username}")
	public String testPathVariable(@PathVariable("id")  Integer id,@PathVariable("username") String username){
		System.out.println("testPathVariable...");
		System.out.println("ID="+id);
		System.out.println("username="+username);
		return "success";
	}
	
	
	//==================================================
	@RequestMapping(value="/testRESTFul/{id}",method=RequestMethod.GET)
	public String testRESTFul_GET(@PathVariable(value="id") Integer id){
		System.out.println("testRESTFul_GET");
		return "success";
//		return "redirect:/springmvc/helloworld";
	}
	
	@RequestMapping(value="/testRESTFul",method=RequestMethod.POST)
	public String testRESTFul_POST(){
		System.out.println("testRESTFul_POST");
		return "success";
	}
	
	
	@RequestMapping(value="/testRESTFul/{id}",method=RequestMethod.PUT)
	public String testRESTFul_PUT(@PathVariable(value="id") Integer id){
		System.out.println("id="+id);
		System.out.println("testRESTFul_PUT");
		return "redirect:/springmvc/helloworld";
	}
	
	
	@RequestMapping(value="/testRESTFul/{id}",method=RequestMethod.DELETE)
	public String testRESTFul_DELETE(@PathVariable(value="id") Integer id){
		System.out.println("id="+id);
		System.out.println("testRESTFul_DELETE");
		return "redirect:/springmvc/helloworld";
	}
	
	
	//==========================================================
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="age",required=false,defaultValue="0") Integer age){
		System.out.println("testRequestParam - age="+age);
		return "success";
	}
	
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language",required=false,defaultValue="zh_CN") String Language){
		System.out.println("testRequestHeader - Language="+Language);
		return "success";
	}
	
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
		System.out.println("testCookieValue - Language="+sessionId);
		return "success";
	}
	
	
	@RequestMapping(value="/testPOJO")
	public String testPOJO(User user){ //2020/08/27 2020-08-07 1,333,444 1333444
		System.out.println("user ="+user);
		return "success";
	}
	
	/*
		1)	HttpServletRequest
		2)	HttpServletResponse
		3)	HttpSession
		4)	java.security.Principal
		5)	Locale
		6)	InputStream
		7)	OutputStream
		8)	Reader
		9)	Writer
	 */
	@RequestMapping(value="/testServletAPI")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response){
		System.out.println("request="+request);
		System.out.println("response="+response);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", "tom");
		return "success";
	}
	
	//========以上演示数据输入========================================
	
	//========以下演示数据输出========================================
	
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){

		//ModelAndView mv = new ModelAndView("success");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("username", "zhangsan");//request.setAttribute("username", "zhangsan");
		
		return mv;
	}
	
	
	@RequestMapping(value="/testMap")
	public String testMap(Map<String,Object> map){
		map.put("username", "lisi");//request.setAttribute("username", "lisi");
		
		User user = new User();
		user.setUsername("user.lisi");
		map.put("user", user);
		return "success";
	}
	
	
	
	
}
