package com.estorezz.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name=SqlConstants.GRANT_INFO)
public class Grant implements Serializable {
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Long grantId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Plan_Id")
	private Plan plan;
	
	@Column(name = "employee_Number")
	private String employeeNumber;
	
	@Column(name = "band")
	private String band;
	
	@Column(name = "number_Of_Grants")
	private Long noOfGrants;
	
	@Column(name = "grant_Price")
	private Double grantPrice;
	
	@Column(name = "grant_Status")
	private String grantStatus;
	
	@Column(name = "accepted_Date")
	private Date acceptedDate;
	
	@Column(name = "granted_Date")
	private Date grantedDate;
	
	@Column(name = "accepted")
	private Boolean accepted;
	
	@Column(name = "allocation_Status")
	private Boolean allocationStatus;

	public Long getGrantId() {
		return grantId;
	}

	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}

	public Plan getPlanId() {
		return plan;
	}

	public void setPlanId(Plan plan) {
		this.plan = plan;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public Long getNoOfGrants() {
		return noOfGrants;
	}

	public void setNoOfGrants(Long noOfGrants) {
		this.noOfGrants = noOfGrants;
	}

	public Double getGrantPrice() {
		return grantPrice;
	}

	public void setGrantPrice(Double grantPrice) {
		this.grantPrice = grantPrice;
	}

	public String getGrantStatus() {
		return grantStatus;
	}

	public void setGrantStatus(String grantStatus) {
		this.grantStatus = grantStatus;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Date getGrantedDate() {
		return grantedDate;
	}

	public void setGrantedDate(Date grantedDate) {
		this.grantedDate = grantedDate;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Boolean getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(Boolean allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	@Override
	public String toString() {
		return "Grant [grantId=" + grantId + ", plan=" + plan + ", employeeNumber=" + employeeNumber + ", band=" + band
				+ ", noOfGrants=" + noOfGrants + ", grantPrice=" + grantPrice + ", grantStatus=" + grantStatus
				+ ", acceptedDate=" + acceptedDate + ", grantedDate=" + grantedDate + ", accepted=" + accepted
				+ ", allocationStatus=" + allocationStatus + "]";
	}

	
}
