package com.clps.restful.crud.handler;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.restful.crud.bean.Department;
import com.clps.restful.crud.bean.Employee;
import com.clps.restful.crud.dao.DepartmentDao;
import com.clps.restful.crud.dao.EmployeeDao;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao ;
	
	@RequestMapping(value="/doUpdate",method=RequestMethod.PUT)
	public String doUpdate(@ModelAttribute("employee") Employee employee){
		
		employeeDao.saveOrUpdate(employee);
		
		return "redirect:/empList";
	}
	
	//@ModelAttribute注解修饰的方法在所有处理请求方法前执行
	@ModelAttribute//ExceptionHandler //InitBinder
	//ControllerAdvice
	public void getEmp(@RequestParam(value="id",required=false) Integer id, Map map){
		if(id!=null){
			System.out.println(id);
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
	public String doAdd(Employee employee){
		
		employeeDao.saveOrUpdate(employee);
		
		return "redirect:/empList"; //重定向查询的handler,获取员工列表数据，再到达list.jsp
	}
	

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
	
}
