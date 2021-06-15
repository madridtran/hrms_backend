package com.tranvanhung.EmployeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranvanhung.EmployeeManagement.model.AttendanceDetail;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceDetail, Long> {
	 List<AttendanceDetail> findByEmployeeId(Long employeeId);
//	 AttendanceDetail findById(long id);
	 Optional<AttendanceDetail> findByIdAndEmployeeId(Long id, Long employeeId);
}
