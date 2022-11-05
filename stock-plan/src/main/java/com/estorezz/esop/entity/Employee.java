package com.estorezz.esop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name = SqlConstants.EMPLOYEE_INFO)
public class Employee implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "employee_Id")
	private Long employeeId;

	@Column(name = "employee_Number")
	private String employeeNumber;

	@Column(name = "full_Name")
	private String fullName;

	@Column(name = "email_Id")
	private String emailId;

	@Column(name = "band")
	private String band;

	@Column(name = "location")
	private String location;

	@Column(name = "employee_Status")
	private String employeeStatus;

	@Column(name = "experience_In_years")
	private Double yearOfExperience;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Double getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Double yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNumber=" + employeeNumber + ", fullName=" + fullName
				+ ", emailId=" + emailId + ", band=" + band + ", location=" + location + ", employeeStatus="
				+ employeeStatus + "]";
	}

}
