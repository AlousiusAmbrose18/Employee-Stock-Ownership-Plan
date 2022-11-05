package com.estorezz.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name=SqlConstants.LOCK_INFO)
public class LockIn implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="Employee_number")
	private String employeeNumber;
	
	@Column(name ="lock_Status")
	private String lockStatus;
	
	@Column(name ="created_Date")
	private Date createdDate;
	
	@Column(name ="modified_Date")
	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "LockIn [id=" + id + ", employeeNumber=" + employeeNumber + ", lockStatus=" + lockStatus
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
