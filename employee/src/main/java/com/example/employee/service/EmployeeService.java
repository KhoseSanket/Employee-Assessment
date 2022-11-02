package com.example.employee.service;

import java.util.List;

import com.example.employee.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);

	public List<Employee> findAll();

	public Employee updateEmployee(Employee emp);

	public Employee findById(Integer id, Employee emp);

	public List<Employee> findByName();

	public void deleteById(Integer id);

	Employee findByEmpId(Integer id);

	

}
