package com.example.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Employee findById(Integer id, Employee emp) {
		// TODO Auto-generated method stub
		Employee emp1 = employeeRepository.findById(id).get();

		//emp1.setId(emp.getId());
		emp1.setName(emp.getName());
		emp1.setDepartment(emp.getDepartment());
		emp1.setSalary(emp.getSalary());

		return emp1;
	}

	@Override
	public List<Employee> findByName() {
		// TODO Auto-generated method stub
		return employeeRepository.findNameOfEmployee();
	}

	@Override
	public Employee findByEmpId(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

}
