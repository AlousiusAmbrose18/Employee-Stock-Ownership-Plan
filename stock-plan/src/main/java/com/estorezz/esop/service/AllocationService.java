package com.estorezz.esop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.estorezz.esop.dto.OptionsDto;
import com.estorezz.esop.entity.Allocation;
import com.estorezz.esop.entity.Grant;
import com.estorezz.esop.entity.Plan;
import com.estorezz.esop.entity.VestedOption;
import com.estorezz.esop.repository.AllocationRepository;
import com.estorezz.esop.repository.VestedOptionRepository;

@Service
@EnableScheduling
public class AllocationService {

	@Autowired
	private AllocationRepository allocationRepository;

	@Autowired
	private GrantService grantService;

	@Autowired
	private MonitizationService monitizationService;

	@Autowired
	private VestedOptionRepository vestedOptionRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Scheduled(cron = "*/10 * * * * *")
	public void initiateAllocation() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				List<Allocation> allocationList = prepareAllocationList();
				allocationRepository.saveAll(allocationList);
			}
		}).start();
	}

	private List<String> brandList() {
		String[] band = { "A5", "A6", "A7", "A8", "A9", "A10" };
		return Arrays.asList(band);

	}

	private List<Allocation> prepareAllocationList() {

		List<Allocation> allocationsList = new ArrayList<>();

		System.out.println("calling.......");
		List<Grant> grantListForAllocation = grantService.getByGrantStatusAndAllocationStatus();

		List<String> brandList = brandList();

		for (Grant grant : grantListForAllocation) {

			if (brandList.contains(grant.getBand())) {
				for (int i = 1; i <= 5; i++) {
					Allocation allocation = new Allocation();
					allocation.setGrant(grant);
					allocation.setAlloactionNumber((double) (grant.getNoOfGrants() / 5));
					allocation.setAllocationStatus("pending");
					allocation.setAlloactionDate(LocalDateTime.now());
					allocation.setAllocationYear(LocalDateTime.now().plusYears(i).getYear() + "");

					grant.setAllocationStatus(true);
					grantService.updateGrant(grant);
					allocationsList.add(allocation);
				}

			} else {
				Allocation allocation = new Allocation();
				allocation.setGrant(grant);
				allocation.setAllocationStatus("pending");
				allocation.setAlloactionDate(LocalDateTime.now());
				allocation.setAllocationYear(LocalDateTime.now().plusYears(1).getYear() + "");
				allocation.setAlloactionNumber((double) (grant.getNoOfGrants()));

				grant.setAllocationStatus(true);
				grantService.updateGrant(grant);

				allocationsList.add(allocation);
			}
		}
		return allocationsList;

	}

	public Allocation getAllocationById(Long alloactionId) {
		return allocationRepository.findById(alloactionId).get();
	}

	public void updateAlloactionStatus(Allocation allocation) {

		allocation.setAllocationStatus("Allocated");
		allocationRepository.save(allocation);
	}

	public void updateAlloactionStatusByAllocationIds(List<Long> allocationsIdList) {

		for (Long allocationId : allocationsIdList) {

			Allocation allocation = getAllocationById(allocationId);

			updateAlloactionStatus(allocation);

			Plan plan = allocation.getGrant().getPlanId();

			Long grantId = allocation.getGrant().getGrantId();

			if (monitizationService.isMonitizationStarted(plan.getPlanId())) {
				VestedOption vestedOption = monitizationService.getVestedOptionByGrantId(grantId);

				Double vOption = allocation.getAlloactionNumber() * plan.getVestingFactor();

				if (vestedOption != null) {
					vestedOption.setVestedOption(vestedOption.getVestedOption() + (vOption));
					vestedOption.setModifiedDate(LocalDateTime.now());

					vestedOptionRepository.save(vestedOption);
				} else {
					VestedOption vestedOptions = new VestedOption();
					vestedOptions.setCreatedDate(LocalDateTime.now());
					vestedOptions.setGrantId(grantId);
					vestedOptions.setModifiedDate(LocalDateTime.now());
					vestedOptions.setVestedOption(vOption);

					vestedOptionRepository.save(vestedOptions);
				}
			}

		}

	}

	@SuppressWarnings("deprecation")
	public List<OptionsDto> findAllocatedAllocationSumByPlan(String planYear) {

		String query = """
				SELECT esop.plan_info.plan_id, esop.grant_info.grant_id, esop.grant_info.employee_number, sum(esop.allocation_info.allocation_number)
				from esop.plan_info left join esop.grant_info
				on esop.grant_info.plan_id = esop.plan_info.plan_id
				left join esop.allocation_info
				on esop.grant_info.grant_id = esop.allocation_info.grant_id
				where esop.allocation_info.allocation_status ="Allocated" and esop.plan_info.plan_year= ? group by esop.grant_info.grant_id;
				""";

		List<OptionsDto> optionsDtoList = jdbcTemplate.query(query, new Object[] { planYear },
				new RowMapper<OptionsDto>() {

					@Override
					public OptionsDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

						return new OptionsDto(resultSet.getString("plan_id"), resultSet.getLong("grant_id"),
								resultSet.getString("employee_number"),
								resultSet.getDouble("sum(esop.allocation_info.allocation_number)"));
					}
				});

		return optionsDtoList;
	}

}