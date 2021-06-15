package com.tranvanhung.EmployeeManagement.model;

import java.sql.Date;

import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false)
	private long employeeId;

	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "gender")
	private String gender;
	@Column(name = "position")
	private String position;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "work_day")
	private int workDay;
//	@Column(name = "status")
//	private Boolean status;
	@Column(name = "email")
	private String email;
	@Column(name = "department_id",insertable = false, updatable = false)
	private long departmentId;
	String shift;
	private String departmentName;
	public String getdepartmentName() {
		String departmentName = department.getNameOfDepartment();
		return departmentName;
	}

	public void setdepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<AttendanceDetail> attendanceDetails = new HashSet<>();

	public Set<AttendanceDetail> getAttendanceDetails() {
		return attendanceDetails;
	}

	public void setAttendanceDetails(Set<AttendanceDetail> attendanceDetails) {
		this.attendanceDetails = attendanceDetails;
	}
//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	private Set<Salary> salarys = new HashSet<>();
//
//	public Set<Salary> getSalarys() {
//		return salarys;
//	}
//
//	public void setSalarys(Set<Salary> salarys) {
//		this.salarys = salarys;
//	}
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;
    
    public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "employee")
	private Salary salary;
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

//	public Employee(String name, String code, String gender, String position, Date dateOfBirth,
//			int workDay, String email, String shift) {
//		super();
//		this.name = name;
//		this.code = code;
//		this.gender = gender;
//		this.position = position;
//		this.dateOfBirth = dateOfBirth;
//		this.workDay = workDay;
//		this.email = email;
//		this.shift = shift;
//	}

	public String getShift() {
		return shift;
	}

	public Employee(String name, String code, String gender, String position, Date dateOfBirth, int workDay,
			String email, long departmentId, String shift) {
		super();
		this.name = name;
		this.code = code;
		this.gender = gender;
		this.position = position;
		this.dateOfBirth = dateOfBirth;
		this.workDay = workDay;
		this.email = email;
		this.departmentId = departmentId;
		this.shift = shift;
	}

	public Employee(String name, String code, String gender, String position, Date dateOfBirth, int workDay,
			String email, long departmentId, String shift, Set<AttendanceDetail> attendanceDetails,
			Department department, Salary salary) {
		super();
		this.name = name;
		this.code = code;
		this.gender = gender;
		this.position = position;
		this.dateOfBirth = dateOfBirth;
		this.workDay = workDay;
		this.email = email;
		this.departmentId = departmentId;
		this.shift = shift;
		this.attendanceDetails = attendanceDetails;
		this.department = department;
		this.salary = salary;
	}

	public void setShift(String shift) {
		this.shift = shift;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

//	public Boolean getStatus() {
//		return status;
//	}
//	public void setStatus(Boolean status) {
//		this.status = status;
//	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
