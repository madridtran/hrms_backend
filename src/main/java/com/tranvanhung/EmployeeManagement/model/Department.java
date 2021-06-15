package com.tranvanhung.EmployeeManagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "department")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", nullable = false)
	private long departmentId;

//	@Column(name = "employee_id", insertable = false, updatable = false)
//	private long employeeId;

	@Column(name = "department_name")
	private String nameOfDepartment;

	@Column(name = "department_location")
	private String locationOfDepartment;

	@Column(name = "department_manager")
	private String managerOfDepartment;

	
//	public long getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(long employeeId) {
//		this.employeeId = employeeId;
//	}
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getNameOfDepartment() {
		return nameOfDepartment;
	}

	public void setNameOfDepartment(String nameOfDepartment) {
		this.nameOfDepartment = nameOfDepartment;
	}

	public String getLocationOfDepartment() {
		return locationOfDepartment;
	}

	public void setLocationOfDepartment(String locationOfDepartment) {
		this.locationOfDepartment = locationOfDepartment;
	}

	public String getManagerOfDepartment() {
		return managerOfDepartment;
	}

	public void setManagerOfDepartment(String managerOfDepartment) {
		this.managerOfDepartment = managerOfDepartment;
	}



	public Department(long departmentId, String nameOfDepartment, String locationOfDepartment,
			String managerOfDepartment, Set<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.nameOfDepartment = nameOfDepartment;
		this.locationOfDepartment = locationOfDepartment;
		this.managerOfDepartment = managerOfDepartment;
		this.employees = employees;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public Department() {
		super();
	}

}
