package com.estorezz.esop.constants;

public interface RequestMappingConstants {
	
//<--------------------------Common Controller---------------------------------------->
	
	public final String COMMON_CONTROLLER = "/commonController";
	
	public final String SAVE_EMPLOYEE_DETAILS = "/saveEmployeeDetails";
	
	public final String FIND_ALL_EMPLOYEE = "/getAllEmployee";

	public final String	SAVE_ALL_EMPLOYEE_DETAILS ="/saveListOfEmployee";
	
	public final String	SAVE_PLAN_INFO ="/savePlanInfo";
	
	public final String	GET_PLAN_BY_ID ="/getPlanById";
	
	public final String	GET_PLAN_BY_PLAN_YEAR ="/getPlanByPlanYear";
	
	public final String	START_MONITIZATION ="/startMonitization";
	
	public final String	PREPARE_VESTED_OPTIONS ="/prepareVestedOptions";
	
	public final String	SAVE_LOCKIN_DETAILS ="/saveLockInDetails";
	
	public final String	GET_LOCKIN_DETAILS_BY_EMPLOYEE_NUMBER ="/getLockInByEmployeeNumber";
	
	public final String	UPDATE_LOCKIN_DETAILS ="/updateLockInDetails";
	
	public final String	SAVE_EXERCISE_DETAILS ="/saveExerciseDetails";
	
	
//<------------------------Grant Controller------------------------------------------>	
	
	public final String GRANT_CONTROLLER ="/GrantController";
	
	public final String GET_BY_GRANT_ID = "/getByGrantId";
	
	public final String UPLOAD_GRANTS = "/uploadGrants";
	
	public final String ACCEPT_GRANT = "/acceptGrant";
	
	public final String APPROVE_GRANTS ="/approveGrants";
	
	
//<--------------------------Allocation Controller------------------------------------>
	
	public final String ALLOCATION_CONTROLLER = "/alloactionController";
	
	public final String APPROVE_ALLOCATION_LIST_BY_GRANT_ID ="/approveAllocationByGrantIdList";
	
	public final String APPROVE_ALLOCATION_BY_GRANT_ID ="/approveAllocationGrantId";
	

}
