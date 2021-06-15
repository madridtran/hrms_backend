package com.tranvanhung.EmployeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tranvanhung.EmployeeManagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 List<Employee> findByDepartmentId(Long departmentId);
//	 AttendanceDetail findById(long id);
	 Optional<Employee> findByEmployeeIdAndDepartmentId(Long employeeId, Long departmentId);
}
