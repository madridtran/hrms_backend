package com.tranvanhung.EmployeeManagement.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranvanhung.EmployeeManagement.model.AttendanceDetail;
import com.tranvanhung.EmployeeManagement.repository.AttendanceRepository;

@Service
public class AttendanceServices implements IAttendanceServices {

	@Autowired
	AttendanceRepository attendanceReporsitory;
	@Override
	public Iterable<AttendanceDetail> findAll() {
		// TODO Auto-generated method stub
		return attendanceReporsitory.findAll();
	}

	@Override
	public Optional<AttendanceDetail> findById(Long id) {
		// TODO Auto-generated method stub
		 return attendanceReporsitory.findById(id);
	}

	@Override
	public AttendanceDetail save(AttendanceDetail t) {
		// TODO Auto-generated method stub
		return attendanceReporsitory.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		attendanceReporsitory.deleteById(id);
		
	}

}
