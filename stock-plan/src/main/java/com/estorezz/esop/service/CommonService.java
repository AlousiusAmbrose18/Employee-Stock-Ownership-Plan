package com.estorezz.esop.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estorezz.esop.dto.VestingDto;
import com.estorezz.esop.entity.Employee;
import com.estorezz.esop.entity.LockIn;
import com.estorezz.esop.entity.Plan;
import com.estorezz.esop.repository.EmployeeRepository;
import com.estorezz.esop.repository.LockInRepository;
import com.estorezz.esop.repository.PlanRepository;

@Service
public class CommonService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private LockInRepository lockInRepository;

	public Plan getPlanById(String planId) {
		return planRepository.findByPlanId(planId);

	}
	
	public Plan getPlanByPlanYear(String planYear)
	{
		return planRepository.findByPlanYear(planYear);
		
	}

	public void savePlanDetails(Plan plan) {

		planRepository.save(plan);
	}

	public void saveEmployeeDetails(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		Employee emp = getByEmployeeNumber(employee.getEmployeeNumber());
		emp.setBand(employee.getBand());
		emp.setEmailId(employee.getEmailId());
		emp.setEmployeeStatus(employee.getEmployeeStatus());
		emp.setFullName(employee.getFullName());
		emp.setLocation(employee.getLocation());
		emp.setYearOfExperience(employee.getYearOfExperience());
		employeeRepository.save(emp);
	}
	

	public Employee getByEmployeeNumber(String employeeNumber) {
		return employeeRepository.findByEmployeeNumber(employeeNumber);
		
	}
	
	public void deleteEmployeeByEmployeeNumber(String employeeNumber) {
		Employee employee = getByEmployeeNumber(employeeNumber);
		employeeRepository.delete(employee);
	}

	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	public void saveAllEmployee(List<Employee> employee) {
		employeeRepository.saveAll(employee);
	}
	
	
	public void startMonitization(VestingDto VestingDto) {
		
		Plan plan = planRepository.findByPlanYear(VestingDto.getPlanYear());
		
		plan.setVestingFactor(VestingDto.getVestingFactor());
		plan.setMonitizationDate(LocalDateTime.now());
		plan.setFairMarketValue(VestingDto.getFairMarketValue());
		
		planRepository.save(plan);
	}

	public void saveLockInDetails(LockIn lockIn) {
		lockIn.setCreatedDate(new Date());
		lockIn.setModifiedDate(new Date());
		lockInRepository.save(lockIn);
	}

	public LockIn getLockInByEmployeeNumber(String employeeNumber)
	{
		return lockInRepository.findByEmployeeNumber(employeeNumber);
	}
	
	public void updateLockInDetails(String employeeNumber) {
		
		LockIn lockIn = getLockInByEmployeeNumber(employeeNumber);
		lockIn.setLockStatus("open");
		lockIn.setModifiedDate(new Date());
		lockInRepository.save(lockIn);
		
	}

	
}
