package com.clps.restful.crud.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clps.restful.crud.bean.Department;
import com.clps.restful.crud.bean.Employee;
import com.clps.restful.crud.dao.DepartmentDao;
import com.clps.restful.crud.dao.EmployeeDao;

@Controller
public class EmployeeHandler /*implements org.springframework.web.servlet.mvc.Controller*/ /*implements HttpRequestHandler*/{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao ;
	
	
	@RequestMapping("testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
	 
		ServletContext servletContext = session.getServletContext();
		InputStream resourceAsStream = servletContext.getResourceAsStream("/files/abc.txt");
		byte[] body = new byte[resourceAsStream.available()] ;
		resourceAsStream.read(body);
		 
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		 
		HttpStatus statusCode = HttpStatus.OK;
		 
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, statusCode);
		 
		return responseEntity ;
	}
	
	//@ResponseBody支持JSON组件,将返回的对象,集合转换为JSON字符串,以流的形式返回给客户端.
//	@ResponseBody
//	@RequestMapping("/testJSON")
//	public Collection<Employee> testJSON(){
//		Collection<Employee> empList = employeeDao.getAll();
//		return empList;
//	}
	
	@RequestMapping("/testJSON")
	public String testJSON(@RequestBody String requset){
		System.out.println(requset);
		return "redirect:/empList";
	}
	
	@RequestMapping(value="/doUpdate",method=RequestMethod.PUT)
	public String doUpdate(@ModelAttribute("employee") Employee employee){
		
		employeeDao.saveOrUpdate(employee);
		
		return "redirect:/empList";
	}
	
	//@ModelAttribute注解修饰的方法在所有处理请求方法前执行
	@ModelAttribute
	public void getEmp(@RequestParam(value="id",required=false) Integer id, Map map){
		if(id!=null){
			Employee employee = employeeDao.get(id);
			map.put("employee", employee);
		}
	}
	
	
	@RequestMapping(value="/toUpdate/{id}",method=RequestMethod.GET)
	public String toUpdate(@PathVariable(value="id") Integer id,Map map){
		Employee employee = employeeDao.get(id);
		map.put("employee", employee);
		
		Collection<Department> departments = departmentDao.getDepartments();
		map.put("deptList", departments);
		
		return "update";
	}
	
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Integer id){
		
		employeeDao.delete(id);
		
		return "redirect:/empList";
	}
	
	
	
	
	@RequestMapping(value="/doAdd",method=RequestMethod.POST)
	public String doAdd(@Valid Employee employee ,BindingResult bindingResult,Map map){
		System.out.println("doAdd");
		if(bindingResult.getErrorCount() > 0 ){
			System.out.println("类型转换出错误了");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
			}
			
			Collection<Department> departments = departmentDao.getDepartments();
			map.put("deptList", departments);
			
			//map.put("command", new Employee());  //request.setAttribute("command",object);
			//map.put("employee", new Employee()); 
			
			return "add";
		}

		
		
		System.out.println(employee);
		employeeDao.saveOrUpdate(employee);
		
		return "redirect:/empList"; //重定向查询的handler,获取员工列表数据，再到达list.jsp
	}
	
	/*
	@InitBinder
	由 @InitBinder 标识的方法，可以对 WebDataBinder 对象进行初始化。WebDataBinder 是 DataBinder 的子类，用于完成由表单字段到 JavaBean 属性的绑定
	@InitBinder方法不能有返回值，它必须声明为void。
	@InitBinder方法的参数通常是 WebDataBinder
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder dataBinder){
//		dataBinder.setDisallowedFields("lastName");
//	}

	

	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Map map){
		
		Collection<Department> departments = departmentDao.getDepartments();
		map.put("deptList", departments);
		
		//map.put("command", new Employee());  //request.setAttribute("command",object);
		map.put("employee", new Employee()); 
		
		return "add";
	}
	
	
	@RequestMapping(value="/empList",method=RequestMethod.GET)
	public String empList(Map map){
		
		Collection<Employee> empList = employeeDao.getAll();
		map.put("empList", empList);
		
		return "list";
	}

/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

/*	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}*/
	
}
