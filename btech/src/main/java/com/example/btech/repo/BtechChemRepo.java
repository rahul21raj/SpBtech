package com.example.btech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.btech.entity.BtechChemEntity;

public interface BtechChemRepo extends JpaRepository<BtechChemEntity, String>{

	public BtechChemEntity findByStudId(String studId);

}
