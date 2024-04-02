package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id)
	{
		return employeeRepository.findById(id);
		
	}
	
	public Employee createEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Long id, Employee employeeDetails )
	{
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
			
		if(optionalEmployee.isPresent())
		{
			Employee existingEmployee = optionalEmployee.get();
			existingEmployee.setName(employeeDetails.getName());
			existingEmployee.setEmail(employeeDetails.getEmail());
			existingEmployee.setDesignation(employeeDetails.getDesignation());
			return employeeRepository.save(existingEmployee);
		}
		else {
		return null;
		}
		
	}
	
	public void deleteEmployee(Long id)
	{
		employeeRepository.deleteById(id);
	}
	
	
	
}
