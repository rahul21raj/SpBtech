package com.example.btech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.btech.VO.BtechVO;
import com.example.btech.VO.MarkVO;
import com.example.btech.VO.StudentVO;
import com.example.btech.VO.SubMarkVO;
import com.example.btech.entity.BtechPersonelEntity;
import com.example.btech.service.BtechRegService;

@RestController
public class BtechRegController {

	@Autowired
	private BtechRegService btechRegService;
	
	@PostMapping("btech/register")
	public ResponseEntity<BtechPersonelEntity> registerUser(
			@RequestBody	BtechVO btechVo){
		
		if(null!=btechVo) {
			BtechPersonelEntity savedUser = btechRegService.userRegistration(btechVo);
			if(null!= savedUser) {
				return new ResponseEntity<BtechPersonelEntity>(savedUser,HttpStatus.CREATED);
			}
		}
		
		return null;
	}
	
	@PostMapping("btech/addMark/{personId}")
	public ResponseEntity<String> addMark(@PathVariable String personId, @RequestBody MarkVO markVo){
		
		if(null!=markVo && CollectionUtils.isNotEmpty(markVo.getMarkList())) {
			
			if(btechRegService.addMarks(personId, markVo)) {
				return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("FAILED",HttpStatus.FAILED_DEPENDENCY);
	}
	
	@PutMapping("btech/update/{personId}")
	public ResponseEntity<BtechPersonelEntity> updateUser(@PathVariable String personId, @RequestBody	BtechVO btechVo){
		
		if(null!=personId && null!=btechVo) {
			BtechPersonelEntity updateUser = btechRegService.updatePersonelDatas(personId,btechVo);
			if(null!= updateUser) {
				return new ResponseEntity<BtechPersonelEntity>(updateUser,HttpStatus.OK);
			}
		}
		return null;
	}
	
	@GetMapping("btech/student/{personId}/{sub}")
	public  StudentVO getStudentDetails(@PathVariable String personId, @PathVariable String sub){
		
		StudentVO studentDetails = btechRegService.getUserDeatils(personId,sub);
		if(null!=studentDetails) {
			return studentDetails;
		}
		return null;
	}
	
	@GetMapping("btech/jpa/test")
	public String testjpa() {
		
		return "success";
	}
}
