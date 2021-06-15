package com.tranvanhung.EmployeeManagement.model;




public class AttendanceMapper {
	/**
	 * 
	 */

	private Long id;
	private long employeeId;
	private String name;
	private String month;
	private String date;
	private Boolean available;
	private String checkin;
	private String checkout;
	private double attencount;

	String shift;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public double getAttencount() {
		return attencount;
	}

	public void setAttencount(double attencount) {
		this.attencount = attencount;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public AttendanceMapper(Long id, long employeeId, String name, String month, String date, Boolean available,
			String checkin, String checkout, double attencount, String shift) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.month = month;
		this.date = date;
		this.available = available;
		this.checkin = checkin;
		this.checkout = checkout;
		this.attencount = attencount;
		this.shift = shift;
	}

	public AttendanceMapper() {
		super();
	}
	

 
  
    
 

	
}
