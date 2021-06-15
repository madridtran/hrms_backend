//package com.tranvanhung.EmployeeManagement.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tranvanhung.EmployeeManagement.exception.ResourceNotFoundException;
//import com.tranvanhung.EmployeeManagement.model.AttendanceDetail;
//import com.tranvanhung.EmployeeManagement.model.Salary;
//import com.tranvanhung.EmployeeManagement.repository.EmployeeRepository;
//import com.tranvanhung.EmployeeManagement.repository.SalaryRepository;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api/v1")
//public class SalaryController {
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	@Autowired
//	private SalaryRepository salaryRepository;
//	@GetMapping("/employee/{employeeId}/salary")
//	public List<Salary> getSalaryByEmployee(@PathVariable(value = "employeeId") Long employeeId) {
//		return salaryRepository.findByEmployeeId(employeeId);
//	}
//	@GetMapping("/employee/salary")
//	public List<Salary> getSalary() {
//		return salaryRepository.findAll();
//	}
//	@PostMapping("/employee/{id}/salary")
//	public Salary createSalary(@PathVariable(value = "id") Long employeeId, @RequestBody Salary salary) throws ResourceNotFoundException {
//		System.out.println(employeeId);
//		return employeeRepository.findById(employeeId).map(employee -> {
//			salary.setEmployee(employee);
//			salary.setSalary();
//			return salaryRepository.save(salary);
//		}).orElseThrow(() -> new ResourceNotFoundException("employee not found"));
//	}
//
//}
