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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "salary")
public class Salary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employee_id", insertable = false, updatable = false)
	private long employeeId;

	@Column(name = "basic_salary")
	private double bSalary;

	@Column(name = "index_salary")
	private double iSalary;

	@Column(name = "salary")
	private double salary;

	@Column(name = "allowance")
	private double allowance;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false,referencedColumnName = "employee_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;
    

	public Salary(long employeeId, double bSalary, double iSalary, double salary, double allowance,
			Employee employee) {
		super();
		this.employeeId = employeeId;
		this.bSalary = bSalary;
		this.iSalary = iSalary;
		this.salary = salary;
		this.allowance = allowance;
		this.employee = employee;
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public double getbSalary() {
		return bSalary;
	}


	public void setbSalary(double bSalary) {
		this.bSalary = bSalary;
	}


	public double getiSalary() {
		return iSalary;
	}


	public void setiSalary(double iSalary) {
		this.iSalary = iSalary;
	}


	public double getSalary() {
		return this.salary;
	}


	public void setSalary() {
		this.salary = this.iSalary*this.bSalary+this.allowance;
	}


	public double getAllowance() {
		return allowance;
	}


	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Salary() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
