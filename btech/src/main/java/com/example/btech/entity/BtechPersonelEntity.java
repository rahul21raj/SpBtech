package com.example.btech.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btech_prsnl_tbl")
public class BtechPersonelEntity {

	@Id
	private String emailId;
	
	@Column(nullable = false)
	private String username;
	
	private int age;
	
	@Column(nullable = false)
	private String dest;
	
	private long phoneNum;
	
	private Date registrationTime;
	
	@Column(unique = true,nullable = false)
	private String personelId;
	
	

	public String getPersonelId() {
		return personelId;
	}

	public void setPersonelId(String personelId) {
		this.personelId = personelId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
	
	
	
}
