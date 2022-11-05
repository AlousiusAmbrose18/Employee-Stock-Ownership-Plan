package com.estorezz.esop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estorezz.esop.constants.RequestMappingConstants;
import com.estorezz.esop.service.AllocationService;

@RestController
@RequestMapping(value=RequestMappingConstants.ALLOCATION_CONTROLLER)
public class allocationController {
	
	@Autowired
	private AllocationService allocationService;

	@PutMapping(value=RequestMappingConstants.APPROVE_ALLOCATION_LIST_BY_GRANT_ID)
	public void approveAllocations(@RequestBody List<Long> allocationIdList) {
		allocationService.updateAlloactionStatusByAllocationIds(allocationIdList);
	}
	
//	@PutMapping(value=RequestMappingConstants.APPROVE_ALLOCATION_BY_GRANT_ID)
//	public void aprovaveAllocationsByGrantId(@RequestHeader Long grantId)
//	{
//		allocationService.updateAlloactionStatusByGrantId(grantId);
//	}
}
