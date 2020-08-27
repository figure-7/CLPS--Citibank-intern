package com.clps.restful.crud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.clps.restful.crud.bean.Department;
import com.clps.restful.crud.bean.Employee;

//自定义类型转换器：将字符串转换为Employee对象
@Component
public class StringToEmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		System.out.println(source);
		if (source != null) {
			String[] strs = source.split("-");
			if (strs != null && strs.length == 4) {
				String lastName = strs[0];
				String email = strs[1];
				Integer gender = Integer.parseInt(strs[2]);
				Integer deptId = Integer.parseInt(strs[3]);
				Department dept = new Department();
				dept.setId(deptId);
				Employee employee = new Employee(null, lastName, email, gender,
						dept);
				System.out.println(source + "--converter--" + employee);
				return employee;
			}
		}
		return null;

	}

}
