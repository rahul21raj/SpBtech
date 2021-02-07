package com.example.btech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.btech.entity.BtechMatEntity;

public interface BtechMatRepo extends JpaRepository<BtechMatEntity, String>{

	public BtechMatEntity findByStudId(String studId);
	
	public List<BtechMatEntity> findByS1GreaterThan(float s1); 

}
