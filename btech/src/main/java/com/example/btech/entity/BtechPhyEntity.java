package com.example.btech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btech_phy_tbl")
public class BtechPhyEntity {

	@Id
	private String studId;
	
	private float s1;
	
	private float s2;
	
	private float s3;
	
	private float s4;

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public float getS1() {
		return s1;
	}

	public void setS1(float s1) {
		this.s1 = s1;
	}

	public float getS2() {
		return s2;
	}

	public void setS2(float s2) {
		this.s2 = s2;
	}

	public float getS3() {
		return s3;
	}

	public void setS3(float s3) {
		this.s3 = s3;
	}

	public float getS4() {
		return s4;
	}

	public void setS4(float s4) {
		this.s4 = s4;
	}
	
	

}
