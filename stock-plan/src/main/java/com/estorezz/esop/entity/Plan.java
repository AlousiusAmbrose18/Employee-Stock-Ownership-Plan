package com.estorezz.esop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name = SqlConstants.PLAN_INFO)
public class Plan implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Plan_Id")
	private String planId;
	
	@Column(name="plan_year")
	private String planYear;

	@Column(name = "years_Of_Plan")
	private Long yearsOfPlan;

	@Column(name = "start_Date")
	private LocalDateTime startDate;

	@Column(name = "actual_End_Date")
	private LocalDateTime actualEndDate;

	@Column(name = "isCurrent_PlanYear")
	private Boolean isCurrentPlanYear;

	@Column(name = "vesting_Factor")
	private Double vestingFactor;

	@Column(name = "monitization_Date")
	private LocalDateTime monitizationDate;

	@Column(name = "fairMarket_Value")
	private Double fairMarketValue;

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Long getYearsOfPlan() {
		return yearsOfPlan;
	}

	public void setYearsOfPlan(Long yearsOfPlan) {
		this.yearsOfPlan = yearsOfPlan;
	}

	public Boolean getIsCurrentPlanYear() {
		return isCurrentPlanYear;
	}

	public void setIsCurrentPlanYear(Boolean isCurrentPlanYear) {
		this.isCurrentPlanYear = isCurrentPlanYear;
	}

	public Double getVestingFactor() {
		return vestingFactor;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public void setVestingFactor(Double vestingFactor) {
		this.vestingFactor = vestingFactor;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
		setActualEndDate();
	}

	public LocalDateTime getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate() {
		actualEndDate = LocalDateTime.now().plusYears(yearsOfPlan);
	}

	public LocalDateTime getMonitizationDate() {
		return monitizationDate;
	}

	public void setMonitizationDate(LocalDateTime monitizationDate) {
		this.monitizationDate = monitizationDate;
	}

	public Double getFairMarketValue() {
		return fairMarketValue;
	}

	public void setFairMarketValue(Double fairMarketValue) {
		this.fairMarketValue = fairMarketValue;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", yearsOfPlan=" + yearsOfPlan + ", startDate=" + startDate
				+ ", actalEndDate=" + actualEndDate + ", isCurrentPlanYear=" + isCurrentPlanYear + ", vestingFactor="
				+ vestingFactor + ", monitizationDate=" + monitizationDate + ", fairMarketValue=" + fairMarketValue
				+ "]";
	}
}
