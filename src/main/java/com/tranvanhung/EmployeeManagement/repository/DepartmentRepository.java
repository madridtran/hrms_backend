package com.tranvanhung.EmployeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranvanhung.EmployeeManagement.model.Department;
import com.tranvanhung.EmployeeManagement.model.Salary;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
//	 List<Department> findByEmployeeId(Long employeeId);
//	 AttendanceDetail findById(long id);
//	 Optional<Department> findByIdAndEmployeeId(Long id, Long employeeId);
}
