package com.estorezz.esop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estorezz.esop.dto.GrantDto;
import com.estorezz.esop.entity.Grant;
import com.estorezz.esop.repository.GrantRepository;
import com.estorezz.esop.repository.PlanRepository;

@Service
public class GrantService {

	@Autowired
	private GrantRepository grantRepository;

	@Autowired
	private PlanRepository planRepository;

	public Grant getGrantById(Long grantId) {
		return grantRepository.findById(grantId).get();
	}

	public void updateGrant(Grant grant) {
		grantRepository.save(grant);
	}

	public void updateGrantsList(List<Grant> grantlist) {
		grantRepository.saveAll(grantlist);
	}

	public void PrepareAndUploadGrants(List<GrantDto> grantDtoList) {
		List<Grant> grantsList = prepareGrants(grantDtoList);
		grantRepository.saveAll(grantsList);
	}

	private List<Grant> prepareGrants(List<GrantDto> grantDtoList) {

		List<Grant> GrantList = new ArrayList<Grant>();

		for (GrantDto grantDto : grantDtoList) {

			Grant grant = new Grant();
			grant.setPlanId(planRepository.findByPlanId(grantDto.getPlanId()));
			grant.setEmployeeNumber(grantDto.getEmployeeNumber());
			grant.setBand(grantDto.getBand());
			grant.setNoOfGrants(grantDto.getNoOfGrants());
			grant.setGrantPrice(grantDto.getGrantPrice());
			grant.setAllocationStatus(false);
			grant.setAccepted(false);
			grant.setGrantStatus("pending");

			GrantList.add(grant);
		}
		return GrantList;
	}

	public void acceptGrant(Long grantId) {
		Grant grant = getGrantById(grantId);
		grant.setAccepted(true);
		grant.setAllocationStatus(false);
		grant.setAcceptedDate(new Date());

		updateGrant(grant);
	}

	public void approveGrants(List<Long> grantIdList) {

		List<Grant> grantedIdList = new ArrayList<>();

		for (Long grantId : grantIdList) {
			Grant grant = getGrantById(grantId);
			grant.setGrantStatus("Granted");
			grant.setGrantedDate(new Date());
			grantedIdList.add(grant);
		}

		updateGrantsList(grantedIdList);
	}

	public List<Grant> getByGrantStatusAndAllocationStatus() {
		return grantRepository.findByGrantStatusAndAllocationStatus("Granted", false);

	}
}
