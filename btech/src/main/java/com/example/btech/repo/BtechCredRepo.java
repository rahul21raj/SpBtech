package com.example.btech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.btech.entity.BtechCredentialEntity;

@Repository
public interface BtechCredRepo extends JpaRepository<BtechCredentialEntity, String>{

}
