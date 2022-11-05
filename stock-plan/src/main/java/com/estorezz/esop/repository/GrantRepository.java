package com.estorezz.esop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estorezz.esop.entity.Grant;

public interface GrantRepository extends JpaRepository<Grant, Long> {

	@Query("from Grant where grantStatus=:granted and allocationStatus=:falseStatus")
	List<Grant> findByGrantStatusAndAllocationStatus(String granted, Boolean falseStatus);

}
