package com.estorezz.esop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estorezz.esop.entity.Exercise;
import com.estorezz.esop.entity.LockIn;
import com.estorezz.esop.entity.VestedOption;
import com.estorezz.esop.repository.ExerciseRepository;
import com.estorezz.esop.repository.VestedOptionRepository;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private CommonService commonService;

	@Autowired
	public GrantService grantService;

	@Autowired
	private MonitizationService monitizationService;

	@Autowired
	private VestedOptionRepository vestedOptionRepository;

	public String saveExercise(Exercise exercise) {

		LockIn lockIn = commonService
				.getLockInByEmployeeNumber((grantService.getGrantById(exercise.getGrantId()).getEmployeeNumber()));

		if (lockIn.getLockStatus().equals("open")) {

			VestedOption vestedOption = monitizationService.getVestedOptionByGrantId(exercise.getGrantId());

			if (vestedOption.getVestedOption() >= exercise.getExerciseOptions()) {

				if (exercise.getExerciseOptions() >= exercise.getSoldOptions()) {

//					vestedOption.setVestedOption(exercise.getVestedOption() - exercise.getExerciseOptions());

					exercise.setVestedOption(monitizationService.getVestedOptionByGrantId(exercise.getGrantId()));
					exercise.setCreatedDate(LocalDateTime.now());
					exercise.setModifiedDate(LocalDateTime.now());

				//	vestedOptionRepository.save(vestedOption);
					exerciseRepository.save(exercise);
					
					System.out.println(exercise);

					return "Exercise data Saved...";
				}

			}
		}
		return "Employee is Locked...";

	}
}
