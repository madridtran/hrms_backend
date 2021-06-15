package com.tranvanhung.EmployeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tranvanhung.EmployeeManagement.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
	 List<Salary> findByEmployeeId(Long employeeId);
//	 AttendanceDetail findById(long id);
	 Optional<Salary> findByIdAndEmployeeId(Long id, Long employeeId);
}
