package com.example.btech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.btech.entity.BtechChemEntity;
import com.example.btech.entity.BtechPhyEntity;

public interface BtechPhyRepo extends JpaRepository<BtechPhyEntity, String>{

	public BtechPhyEntity findByStudId(String studId);

}
