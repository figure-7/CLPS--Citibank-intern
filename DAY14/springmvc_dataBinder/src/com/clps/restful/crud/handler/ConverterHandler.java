package com.clps.restful.crud.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.restful.crud.bean.Employee;
import com.clps.restful.crud.dao.EmployeeDao;

@Controller
public class ConverterHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/empAdd",method=RequestMethod.POST)
	public String doSave(@RequestParam("employee") Employee employee){
		System.out.println("emp add" + employee);
		employeeDao.saveOrUpdate(employee);
		return "redirect:/empList";
	}
	
}
