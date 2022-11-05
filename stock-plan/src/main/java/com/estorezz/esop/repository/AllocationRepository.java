package com.estorezz.esop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.estorezz.esop.entity.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

}
