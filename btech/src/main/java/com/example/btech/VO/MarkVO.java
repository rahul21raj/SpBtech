package com.example.btech.VO;

import java.util.List;

public class MarkVO {

	private List<SubMarkVO> markList;
	
	private String semster;

	public List<SubMarkVO> getMarkList() {
		return markList;
	}

	public void setMarkList(List<SubMarkVO> markList) {
		this.markList = markList;
	}
	
	public String getSemster() {
		return semster;
	}

	public void setSemster(String semster) {
		this.semster = semster;
	}
	
	
}
