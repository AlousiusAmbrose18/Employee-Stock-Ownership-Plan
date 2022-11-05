package com.estorezz.esop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name = SqlConstants.ALLOCATION_INFO)
public class Allocation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "grant_id")
	private Grant grant;

	@Column(name = "allocation_number")
	private Double allocationNumber;

	@Column(name = "allocation_Status")
	private String allocationStatus;

	@Column(name = "allocation_year")
	private String allocationYear;

	@Column(name = "allocation_Date")
	private LocalDateTime allocationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Grant getGrant() {
		return grant;
	}

	public void setGrant(Grant grant) {
		this.grant = grant;
	}

	public Double getAlloactionNumber() {
		return allocationNumber;
	}

	public void setAlloactionNumber(Double allocationNumber) {
		this.allocationNumber = allocationNumber;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getAllocationYear() {
		return allocationYear;
	}

	public void setAllocationYear(String allocationYear) {
		this.allocationYear = allocationYear;
	}

	public LocalDateTime getAlloactionDate() {
		return allocationDate;
	}

	public void setAlloactionDate(LocalDateTime alloactionDate) {
		this.allocationDate = alloactionDate;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", grant=" + grant + ", alloactionNumber=" + allocationNumber
				+ ", allocationStatus=" + allocationStatus + ", allocationYear=" + allocationYear + ", alloactionDate="
				+ allocationDate + "]";
	}



}
