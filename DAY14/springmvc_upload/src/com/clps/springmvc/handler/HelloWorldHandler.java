package com.clps.springmvc.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//XxxHandler用于处理请求的应用程序，代替Servlet，单例的。
@Controller
@RequestMapping(value="/springmvc") //表示映射一个父路径
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
	
	
	//框架负责文件上传,将文件上传到服务器的临时目录下了,然后,将临时目录下的文件以MultipartFile封装,传递给处理器方法入参.
	//可以根据MultipartFile获取文件的信息,可以将这些信息存储到数据库表中
	@RequestMapping("/testUpload")
	public String upload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file, Map<String, String> map) throws IOException{
		
		byte[] bytes = file.getBytes();
		String contentType = file.getContentType();
		InputStream inputStream = file.getInputStream();
		String name = file.getName();
		String originalFilename = file.getOriginalFilename();
		long size = file.getSize();
		
		System.out.println("contentType="+contentType);
		System.out.println("inputStream="+inputStream);
		System.out.println("name="+name);
		System.out.println("originalFilename="+originalFilename);
		System.out.println("size="+size);
		
		/*
		contentType=text/plain
		inputStream=java.io.ByteArrayInputStream@285e2c1
		name=file
		originalFilename=abc.txt
		size=3
		 */
		File file2 = new File("C:/Users/ASUS/Desktop/clps/tmp/", file.getOriginalFilename());
		map.put("filepath", file2.getAbsolutePath());
		map.put("filename",file.getOriginalFilename());
		System.out.println(file2.getAbsolutePath());
		file.transferTo(file2);
		
		return "success";
	}
	
	@RequestMapping("/testUploadMany")
	public String uploadMany(@RequestParam("desc") String desc, @RequestParam("files") MultipartFile[] files) throws IOException{
		for (MultipartFile file : files) {
			
			byte[] bytes = file.getBytes();
			String contentType = file.getContentType();
			InputStream inputStream = file.getInputStream();
			String name = file.getName();
			String originalFilename = file.getOriginalFilename();
			long size = file.getSize();
			
			System.out.println("contentType="+contentType);
			System.out.println("inputStream="+inputStream);
			System.out.println("name="+name);
			System.out.println("originalFilename="+originalFilename);
			System.out.println("size="+size);
			
			
			File file2 = new File("C:/Users/ASUS/Desktop/clps/tmp/", file.getOriginalFilename());
			file.transferTo(file2);
		}
		
		return "success";
	}
	
	@RequestMapping("/fileDownLoad/{fileName:.+}")
	public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, @PathVariable String fileName)
			throws Exception {
		System.out.println(fileName);
		String realPath = "C:/Users/ASUS/Desktop/clps/tmp/" + fileName;// 得到文件所在位置
		InputStream in = new FileInputStream(new File(realPath));// 将该文件加入到输入流之中
		byte[] body = null;
		body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
		in.read(body);// 读入到输入流里面

		fileName = new String(fileName.getBytes("gbk"), "iso8859-1");// 防止中文乱码
		HttpHeaders headers = new HttpHeaders();// 设置响应头
		headers.add("Content-Disposition", "attachment;filename=" + fileName);
		HttpStatus statusCode = HttpStatus.OK;// 设置响应吗
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		in.close();
		return response;

	}
	
}
