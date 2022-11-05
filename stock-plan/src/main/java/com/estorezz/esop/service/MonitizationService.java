package com.estorezz.esop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estorezz.esop.dto.OptionsDto;
import com.estorezz.esop.dto.VestingDto;
import com.estorezz.esop.entity.VestedOption;
import com.estorezz.esop.repository.PlanRepository;
import com.estorezz.esop.repository.VestedOptionRepository;

@Service
public class MonitizationService {

	@Autowired
	private AllocationService allocationService;

	@Autowired
	private VestedOptionRepository vestedOptionRepository;

	@Autowired
	private PlanRepository planRepository;

	public void saveVestedList(List<VestedOption> vestedOption) {
		vestedOptionRepository.saveAll(vestedOption);
	}

	public Boolean isMonitizationStarted(String planId) {
		if (planRepository.findByPlanId(planId).getMonitizationDate() != null)
			return true;

		return false;

	}

	public VestedOption getVestedOptionByGrantId(Long grantId) {
		return vestedOptionRepository.findById(grantId).get();

	}

	public void prepareVestedOption(VestingDto VestingDto) {

		List<OptionsDto> optionDtoList = allocationService.findAllocatedAllocationSumByPlan(VestingDto.getPlanYear());

		List<VestedOption> vestedList = new ArrayList<>();

		for (OptionsDto optionsDto : optionDtoList) {

			VestedOption vestedOption = new VestedOption();

			vestedOption.setCreatedDate(LocalDateTime.now());
			vestedOption.setModifiedDate(LocalDateTime.now());
			vestedOption.setVestedOption(optionsDto.getAllocatedSum() * VestingDto.getVestingFactor());
			vestedOption.setGrantId(optionsDto.getGrantId());

			vestedList.add(vestedOption);
		}

		saveVestedList(vestedList);
	}
}
