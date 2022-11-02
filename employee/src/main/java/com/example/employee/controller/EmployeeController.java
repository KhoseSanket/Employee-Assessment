package com.example.employee.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	// create api for adding the employee details
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<Employee> save(@RequestBody Employee emp) {
		Employee addemp = employeeService.saveEmployee(emp);
		return ResponseEntity.ok().body(addemp);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> listEmp = employeeService.findAll();
		return ResponseEntity.ok().body(listEmp);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") Integer id, @RequestBody Employee emp) {

		Employee updateEmp = employeeService.findById(id, emp);

		return ResponseEntity.ok().body(updateEmp);

	}

	@GetMapping("/getName")
	public ResponseEntity<List<Employee>> getName() {

		List<Employee> listEmp = employeeService.findByName();
		return ResponseEntity.ok().body(listEmp);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, String> map(@PathVariable("id") Integer id) {
		Employee emp = employeeService.findByEmpId(id);

		if (emp != null) {
			employeeService.deleteById(id);
			return Collections.singletonMap("success", "Record Deleted Successfully");
		} else {
			return Collections.singletonMap("fail", "Something is wrong");
		}

	}

}
