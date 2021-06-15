package com.tranvanhung.EmployeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvanhung.EmployeeManagement.exception.ResourceNotFoundException;
import com.tranvanhung.EmployeeManagement.model.Department;
import com.tranvanhung.EmployeeManagement.model.Employee;
import com.tranvanhung.EmployeeManagement.model.Salary;
import com.tranvanhung.EmployeeManagement.repository.DepartmentRepository;
import com.tranvanhung.EmployeeManagement.repository.EmployeeRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/api/v1")
public class DepartmentController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
//	@GetMapping("/employee/{employeeId}/salary")
//	public List<Department> getDepartmentByEmployee(@PathVariable(value = "employeeId") Long employeeId) {
//		return departmentRepository.findByEmployeeId(employeeId);
//	}
	@GetMapping("/department")
	public List<Department> getDepartment() {
		return departmentRepository.findAll();
	}
//	@PostMapping("/employee/{id}/salary")
//	public Salary createSalary(@PathVariable(value = "id") Long employeeId, @RequestBody Salary salary) throws ResourceNotFoundException {
//		System.out.println(employeeId);
//		return employeeRepository.findById(employeeId).map(employee -> {
//			salary.setEmployee(employee);
//			salary.setSalary();
//			return salaryRepository.save(salary);
//		}).orElseThrow(() -> new ResourceNotFoundException("employee not found"));
//	}
	@PostMapping("/department")
	
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable Long id){
		Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Employee with id:" + id));
		departmentRepository.delete(department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@PutMapping("/department/{id}")
	public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id,@RequestBody Department departments){
		Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Employee with id:" + id));
		department.setLocationOfDepartment(departments.getLocationOfDepartment());
		department.setManagerOfDepartment(departments.getManagerOfDepartment());
		department.setNameOfDepartment(departments.getNameOfDepartment());
		
		
		Department updateDepartment = departmentRepository.save(department);
		return ResponseEntity.ok(updateDepartment);
		
	}
}
