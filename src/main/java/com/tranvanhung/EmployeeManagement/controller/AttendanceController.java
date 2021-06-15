package com.tranvanhung.EmployeeManagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvanhung.EmployeeManagement.exception.ResourceNotFoundException;
import com.tranvanhung.EmployeeManagement.model.AttendanceMapper;
import com.tranvanhung.EmployeeManagement.model.AttendanceDetail;
import com.tranvanhung.EmployeeManagement.model.Employee;
import com.tranvanhung.EmployeeManagement.repository.AttendanceRepository;
import com.tranvanhung.EmployeeManagement.repository.EmployeeRepository;
import com.tranvanhung.EmployeeManagement.security.services.AttendanceServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class AttendanceController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employee/{employeeId}/attendance")
	public List<AttendanceDetail> getAttendanceByEmployee(@PathVariable(value = "employeeId") Long employeeId) {
		return attendanceRepository.findByEmployeeId(employeeId);
	}

	@GetMapping("/employee/attendance")
	public List<AttendanceDetail> getAttendance() {

		return attendanceRepository.findAll();
	}

	@PostMapping("/employee/{employeeId}/attendance")
	public AttendanceDetail createAttendanceDetail(@PathVariable(value = "employeeId") Long employeeId,
			@Valid @RequestBody AttendanceDetail attendanceDetail) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId).map(employee -> {
			attendanceDetail.setEmployee(employee);
			return attendanceRepository.save(attendanceDetail);
		}).orElseThrow(() -> new ResourceNotFoundException("employee not found"));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/employee/{employeeId}/checkIn")
	public AttendanceDetail createCheckInAttendanceDetail(@PathVariable(value = "employeeId") Long employeeId)
			throws ResourceNotFoundException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/Mm/yyyy");
		Date date = new Date();
		Date date2 = new Date();
		String s = formatter.format(date);
		String s2 = formatter2.format(date);
		String hourIn = s.substring(0, 2);
		String minuteIn = s.substring(3, 5);
		String dateIn = s2.substring(0, 2);
		String monthIn = s2.substring(3, 4);
		AttendanceDetail attendanceDetail = new AttendanceDetail();

		String checkIn = hourIn + "." + String.valueOf((Integer.parseInt(minuteIn) * 100) / 60);
		return employeeRepository.findById(employeeId).map(employee -> {

			attendanceDetail.setEmployee(employee);
			attendanceDetail.setCheckin(checkIn);
			attendanceDetail.setDate(dateIn);
			attendanceDetail.setMonth(monthIn);
			attendanceDetail.setCheckout(null);
			return attendanceRepository.save(attendanceDetail);
		}).orElseThrow(() -> new ResourceNotFoundException("employee not found"));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/employee/{employeeId}/checkOut")
	public AttendanceDetail updateAttendanceDetail(@PathVariable(value = "employeeId") Long employeeId)
			throws ResourceNotFoundException {
		long attendanceIdmax = 0;
		if (!employeeRepository.existsById(employeeId)) {
			throw new ResourceNotFoundException("employeeId not found");
		} else {
			List<AttendanceDetail> attendanceDetailList = attendanceRepository.findByEmployeeId(employeeId);
			for (AttendanceDetail attendanceDetail : attendanceDetailList) {
				if (attendanceDetail.getId() > attendanceIdmax) {
					attendanceIdmax = attendanceDetail.getId();
				}
			}
			return attendanceRepository.findById(attendanceIdmax).map(attendance -> {
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				Date date = new Date();
				String s = formatter.format(date);
				String hourOut = s.substring(0, 2);
				String minuteOut = s.substring(3, 5);
				String checkOut = hourOut + "." + String.valueOf((Integer.parseInt(minuteOut) * 100) / 60);
				attendance.setCheckout(checkOut);
				attendance.setAttencount();
//			attendance.setAttencount((Double.parseDouble(checkOut))
//						- (Double.parseDouble(attendanceRepository.findById(attendanceIdmax).get().getCheckin())));
				return attendanceRepository.save(attendance);
			}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
		}
	}
}
