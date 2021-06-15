package com.tranvanhung.EmployeeManagement.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "attendancedetail")
public class AttendanceDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employee_id", insertable = false, updatable = false)
	private long employeeId;

	@Column(name = "month")
	private String month;

	@Column(name = "date")
	private String date;

	@Column(name = "available")
	private Boolean available;

	@Column(name = "checkin")
	private String checkin;

	@Column(name = "checkout")
	private String checkout;

	@Column(name = "attencount")
	private double attencount;
	private String name;
	public String getName() {
		String name = employee.getName();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String shift;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnoreProperties(value = {"attendancedetail", "hibernateLazyInitializer"})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;
    
    
	public AttendanceDetail() {
		super();
	}

	public AttendanceDetail(long employeeId, String month, String date, Boolean available, String checkin,
			String checkout, long attencount, String shift) {
		super();
		this.employeeId = employeeId;
		this.month = month;
		this.date = date;
		this.available = available;
		this.checkin = checkin;
		this.checkout = checkout;
		this.attencount = attencount;
		this.shift = shift;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public double getAttencount() {
		return attencount;
	}



	public void setAttencount() {
		this.attencount =Double.parseDouble(this.checkout)-Double.parseDouble(this.checkin);
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
