package com.estorezz.esop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estorezz.esop.constants.RequestMappingConstants;
import com.estorezz.esop.dto.GrantDto;
import com.estorezz.esop.entity.Grant;
import com.estorezz.esop.service.GrantService;

@RestController
@RequestMapping(value=RequestMappingConstants.GRANT_CONTROLLER)
public class GrantController {

	@Autowired
	private GrantService grantService;
	
	@GetMapping(value=RequestMappingConstants.GET_BY_GRANT_ID)
	public @ResponseBody Grant getGrantById(@RequestHeader("grantId") Long grantId) {
		return grantService.getGrantById(grantId);
	}
	
	
	@PostMapping(value=RequestMappingConstants.UPLOAD_GRANTS)
	public void PrepareAndUploadGrants(@RequestBody List<GrantDto> grantDtoList)
	{
		grantService.PrepareAndUploadGrants(grantDtoList);
	}
	
	@PutMapping(value=RequestMappingConstants.ACCEPT_GRANT)
	public void acceptGrant(@RequestHeader("grantId") Long grantId)
	{
		grantService.acceptGrant(grantId);
	}
	
	@PostMapping(value=RequestMappingConstants.APPROVE_GRANTS)
	public void approveGrants(@RequestBody List<Long> grantIdList) {
		grantService.approveGrants(grantIdList);
	}
	
	
	
	
}
