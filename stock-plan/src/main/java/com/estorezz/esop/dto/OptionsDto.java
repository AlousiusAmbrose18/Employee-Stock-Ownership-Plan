package com.estorezz.esop.dto;

public class OptionsDto {

	private Long grantId;

	private Double allocatedSum;

	private String employeeNumber;

	private String planId;

	public OptionsDto(String planId, Long grantId, String employeeNumber, Double allocatedSum) {

		this.planId = planId;
		this.grantId = grantId;
		this.employeeNumber = employeeNumber;
		this.allocatedSum = allocatedSum;
		
	}

	public Long getGrantId() {
		return grantId;
	}

	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}

	public Double getAllocatedSum() {
		return allocatedSum;
	}

	public void setAllocatedSum(Double allocatedSum) {
		this.allocatedSum = allocatedSum;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "OptionsDto [grantId=" + grantId + ", allocatedSum=" + allocatedSum + ", employeeNumber="
				+ employeeNumber + ", planId=" + planId + "]";
	}

}
