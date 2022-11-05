package com.estorezz.esop.dto;

public class GrantDto {

	private String employeeNumber;

	private String band;

	private Long noOfGrants;

	private Double grantPrice;
	
	private String planId;

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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "GrantDto [employeeNumber=" + employeeNumber + ", band=" + band + ", noOfGrants=" + noOfGrants
				+ ", grantPrice=" + grantPrice + ", planId=" + planId + "]";
	}
	
	


}
