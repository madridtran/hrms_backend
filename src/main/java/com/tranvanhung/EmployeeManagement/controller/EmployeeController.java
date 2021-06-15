package com.tranvanhung.EmployeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tranvanhung.EmployeeManagement.exception.ResourceNotFoundException;
import com.tranvanhung.EmployeeManagement.model.Department;
import com.tranvanhung.EmployeeManagement.model.Employee;
import com.tranvanhung.EmployeeManagement.model.Salary;
import com.tranvanhung.EmployeeManagement.repository.DepartmentRepository;
import com.tranvanhung.EmployeeManagement.repository.EmployeeRepository;
import com.tranvanhung.EmployeeManagement.repository.SalaryRepository;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4000")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private SalaryRepository salaryRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//get all employees
	@GetMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	@CrossOrigin(origins = "http://localhost:4000")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		}
	@GetMapping("/employee")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Employee> getAllEmployees2(){
		return employeeRepository.findAll();
		}
	//create employees
	@PostMapping("/employees")
	
	public Employee createEmployee(@RequestBody Employee employee) {
		long departmentId = employee.getDepartmentId();
		return departmentRepository.findById(departmentId).map(department -> {
			long id=employeeRepository.save(employee).getEmployeeId();
			Salary salary = employee.getSalary();
			salary.setEmployee(employee);
			salary.setSalary();
			salaryRepository.save(salary);	
			employee.setDepartment(department);
			return employeeRepository.save(employee);
		}).orElseThrow(() -> new ResourceNotFoundException("department not found"));
	}
		
	//get employeeById
	@GetMapping("/employees/{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Employee with id:" + id));
		return ResponseEntity.ok(employee); 
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Employee with id:" + id));
		employee.setCode(employeeDetails.getCode());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
//		employee.setDepartment(employeeDetails.getDepartment());
		employee.setName(employeeDetails.getGender());
		employee.setPosition(employeeDetails.getPosition());
		employee.setWorkDay(employeeDetails.getWorkDay());
		employee.setEmail(employeeDetails.getEmail());
		employee.setGender(employeeDetails.getEmail());
		
		Employee udateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(udateEmployee);
		
	}
	//delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Employee with id:" + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
