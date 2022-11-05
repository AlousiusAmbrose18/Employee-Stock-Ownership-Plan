package com.estorezz.esop.dto;

public class VestingDto {
	
	private String planYear;
	
	private Double vestingFactor;
	
	private Double fairMarketValue;

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public Double getVestingFactor() {
		return vestingFactor;
	}

	public void setVestingFactor(Double vestingFactor) {
		this.vestingFactor = vestingFactor;
	}

	public Double getFairMarketValue() {
		return fairMarketValue;
	}

	public void setFairMarketValue(Double fairMarketValue) {
		this.fairMarketValue = fairMarketValue;
	}
	
	

}
