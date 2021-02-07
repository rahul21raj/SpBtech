package com.example.btech.VO;

public class StudentVO {

	private String username;

	private int age;

	private long phoneNum;

	private String personelId;
	
	private float s1;
	
	private float s2;
	
	private float s3;
	
	private float s4;
	
	

	public StudentVO(String username, int age, long phoneNum, String personelId, float s1, float s2, float s3,
			float s4) {
		super();
		this.username = username;
		this.age = age;
		this.phoneNum = phoneNum;
		this.personelId = personelId;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
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

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPersonelId() {
		return personelId;
	}

	public void setPersonelId(String personelId) {
		this.personelId = personelId;
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
