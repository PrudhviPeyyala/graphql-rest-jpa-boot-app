package com.sb.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.sb.model.Employee;
import com.sb.service.StudentService;

@Controller
public class EmployeeResolvers {
	
	@Autowired
	private StudentService employeeService;
	
	@QueryMapping
	public List<Employee> findAllEmployees() {
		return employeeService.getAllEmployees();
	}
}
