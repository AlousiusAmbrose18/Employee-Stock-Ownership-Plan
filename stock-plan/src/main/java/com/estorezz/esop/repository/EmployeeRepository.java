package com.estorezz.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estorezz.esop.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmployeeNumber(String employeeNumber);

	

}
