package org.masud.rest;

import java.util.List;

import org.masud.rest.domain.Employee;
import org.masud.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody List<Employee> empList(){
		
		return employeeService.getList();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody List<Employee> addEList(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return employeeService.getList();
	}
	
}
