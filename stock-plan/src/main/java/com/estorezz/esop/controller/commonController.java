package com.estorezz.esop.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estorezz.esop.constants.RequestMappingConstants;
import com.estorezz.esop.dto.VestingDto;
import com.estorezz.esop.entity.Employee;
import com.estorezz.esop.entity.Exercise;
import com.estorezz.esop.entity.LockIn;
import com.estorezz.esop.entity.Plan;
import com.estorezz.esop.service.CommonService;
import com.estorezz.esop.service.ExerciseService;
import com.estorezz.esop.service.MonitizationService;

/**
 * @author Alousi
 * This is CommonController Class which Maps Requests 
 * Like Save and Fetch Details of Plan, Employee and lockIn Entities
 *
 */

@RestController
@RequestMapping(value = RequestMappingConstants.COMMON_CONTROLLER)
@CrossOrigin("http://localhost:4200")
public class commonController {

	@Autowired
	private CommonService CommonService;

	@Autowired
	private MonitizationService monitizationService;

	@Autowired
	private ExerciseService exerciseService;

	private final Logger log = LoggerFactory.getLogger(commonController.class);

	/**
	 * @param planId
	 * 
	 *               This method which is used to fetch the Plan entity details from
	 *               DataBase using Plan Id
	 * 
	 * @return Plan Object
	 * 
	 */
	@GetMapping(value = RequestMappingConstants.GET_PLAN_BY_ID)
	public @ResponseBody Plan getPlanById(@RequestHeader("planId") String planId) {
		return CommonService.getPlanById(planId);
	}

	@GetMapping(value = RequestMappingConstants.GET_PLAN_BY_PLAN_YEAR)
	public @ResponseBody Plan getPlanByPlanYear(@RequestHeader("planYear") String planYear) {
		return CommonService.getPlanByPlanYear(planYear);

	}
	
	@GetMapping(value ="getByEmployeeNumber/{employeeNumber}")
	public @ResponseBody Employee getByEmployeeNumber(@PathVariable String employeeNumber) {
		System.out.println(employeeNumber);
		Employee employee = CommonService.getByEmployeeNumber(employeeNumber);
		System.out.println(employee);
		return employee;
	}
	
	@PutMapping(value ="updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		CommonService.updateEmployee(employee);
	}

	@PostMapping(value = RequestMappingConstants.SAVE_PLAN_INFO)
	public void savePlanDetails(@RequestBody Plan plan) {
		plan.setStartDate(LocalDateTime.now());
		CommonService.savePlanDetails(plan);

	}
	
	@DeleteMapping(value ="deleteByEmployeeNumber/{employeeNumber}")
	public void deleteEmployeeByEmployeeNumber(@PathVariable String employeeNumber) {
		CommonService.deleteEmployeeByEmployeeNumber(employeeNumber);
	}

	@PostMapping(value = RequestMappingConstants.SAVE_EMPLOYEE_DETAILS)
	public void saveEmployeeDetails(@RequestBody Employee employee) {
		CommonService.saveEmployeeDetails(employee);
	}

	@GetMapping(value = RequestMappingConstants.FIND_ALL_EMPLOYEE)
	public @ResponseBody List<Employee> getAllEmployees() {
		return CommonService.getAllEmployees();
	}

	@PostMapping(value = RequestMappingConstants.SAVE_ALL_EMPLOYEE_DETAILS)
	public void saveAllEmployee(@RequestBody List<Employee> employee) {
		CommonService.saveAllEmployee(employee);
	}

	@PostMapping(value = RequestMappingConstants.START_MONITIZATION)
	public void startMonitization(@RequestBody VestingDto vestingDto) {
		CommonService.startMonitization(vestingDto);
	}

	@PostMapping(value = RequestMappingConstants.PREPARE_VESTED_OPTIONS)
	public void prepareVestedOptions(@RequestBody VestingDto vestingDto) {
		monitizationService.prepareVestedOption(vestingDto);
	}

	@PostMapping(value = RequestMappingConstants.SAVE_LOCKIN_DETAILS)
	public void saveLockInDetails(@RequestBody LockIn lockIn) {
		CommonService.saveLockInDetails(lockIn);
	}

	@GetMapping(value = RequestMappingConstants.GET_LOCKIN_DETAILS_BY_EMPLOYEE_NUMBER)
	public @ResponseBody LockIn getLockInByEmployeeNumber(@RequestHeader String employeeNumber) {
		return CommonService.getLockInByEmployeeNumber(employeeNumber);
	}

	@PutMapping(value = RequestMappingConstants.UPDATE_LOCKIN_DETAILS)
	public void updateLockInDetails(@RequestHeader("employeeNumber") String employeeNumber) {
		CommonService.updateLockInDetails(employeeNumber);
	}

	@PostMapping(value = RequestMappingConstants.SAVE_EXERCISE_DETAILS)
	public @ResponseBody String saveExercise(@RequestBody Exercise exercise) {
		return exerciseService.saveExercise(exercise);

	}

}
