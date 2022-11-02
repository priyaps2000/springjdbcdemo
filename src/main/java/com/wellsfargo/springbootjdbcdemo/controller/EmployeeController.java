package com.wellsfargo.springbootjdbcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.springbootjdbcdemo.dao.EmployeeDAO;
import com.wellsfargo.springbootjdbcdemo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO eDAO;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		System.out.println(eDAO.getAll());
		return eDAO.getAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return eDAO.getById(id);
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return eDAO.save(employee)+" No. of rows saved to the database";
	}
	
	@PutMapping("employees/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return eDAO.update(employee, id) + " No. of rows updated to the database";
	}
	
	@DeleteMapping("employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return eDAO.delete(id)+" No. of roes deleted from the database";
	}
	
}
