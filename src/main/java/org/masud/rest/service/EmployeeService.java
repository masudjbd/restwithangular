package org.masud.rest.service;

import java.util.List;

import org.masud.rest.domain.Employee;
import org.masud.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getList(){
		return employeeRepository.getList();
	}


	public void addEmployee(Employee employee) {
		 
		employeeRepository.addEmployee(employee);
		
	}
	
	
}
