package com.estorezz.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estorezz.esop.entity.LockIn;

public interface LockInRepository extends JpaRepository<LockIn, Long> {

	public LockIn findByEmployeeNumber(String employeeNumber);

}
