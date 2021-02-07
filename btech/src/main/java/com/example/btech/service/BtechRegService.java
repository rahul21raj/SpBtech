package com.example.btech.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.btech.VO.BtechVO;
import com.example.btech.VO.MarkVO;
import com.example.btech.VO.StudentVO;
import com.example.btech.VO.SubMarkVO;
import com.example.btech.entity.BtechChemEntity;
import com.example.btech.entity.BtechCredentialEntity;
import com.example.btech.entity.BtechMatEntity;
import com.example.btech.entity.BtechPersonelEntity;
import com.example.btech.entity.BtechPhyEntity;
import com.example.btech.repo.BtechChemRepo;
import com.example.btech.repo.BtechCredRepo;
import com.example.btech.repo.BtechMatRepo;
import com.example.btech.repo.BtechPhyRepo;
import com.example.btech.repo.BtechPrsnlRepo;

import antlr.StringUtils;

@Service
public class BtechRegService {

	@Autowired
	private BtechCredRepo credRepo;
	
	@Autowired
	private BtechPrsnlRepo prsnlRepo;
	
	@Autowired
	private BtechChemRepo chemRepo;
	
	@Autowired
	private BtechPhyRepo phyRepo;
	
	@Autowired
	private BtechMatRepo matRepo;
	
	public BtechPersonelEntity userRegistration(BtechVO btechVo) {
		
		if(insertCredRepo(btechVo)) {
			
			return insertPrsnlRepo(btechVo);
		}
		return null;
	}

	
	private boolean insertCredRepo(BtechVO btechVo) {
		
		BtechCredentialEntity btechCredEntity = new BtechCredentialEntity();
		btechCredEntity.setEmailId(btechVo.getEmailId());
		btechCredEntity.setPassword(btechVo.getPassword());
		btechCredEntity.setRole(btechVo.getRole());
		if(null != credRepo.save(btechCredEntity)) {
			return true;
		}
		
		return false;
	}
	
	private BtechPersonelEntity insertPrsnlRepo(BtechVO btechVo) {
		
		BtechPersonelEntity btechPersonelEntity = new BtechPersonelEntity();
		btechPersonelEntity.setEmailId(btechVo.getEmailId());
		btechPersonelEntity.setUsername(btechVo.getUsername());
		btechPersonelEntity.setDest(btechVo.getDest());
		btechPersonelEntity.setAge(btechVo.getAge());
		btechPersonelEntity.setPhoneNum(btechVo.getPhoneNum());
		btechPersonelEntity.setPersonelId(btechVo.getPersonelId());
		btechPersonelEntity.setRegistrationTime(Calendar.getInstance().getTime());
		return prsnlRepo.save(btechPersonelEntity);
	}
	
	public boolean addMarks(String personId , MarkVO markVo) {
		
		if(null!=personId) {
		//	
			BtechPersonelEntity btechPersonelEntity =prsnlRepo.findByPersonelId(personId);
			if(null!= btechPersonelEntity) {
				String dest = btechPersonelEntity.getDest();
				
				switch(dest) {
				case "Chem" : return addChem(markVo);
				
				case "Phy"	: return addPhy(markVo);
				
				case "Mat"	: return addMat(markVo);
							  	
				}
			}
		}
		return false;
	}
	



	private boolean addChem(MarkVO markVo) {
		List<SubMarkVO> markList = markVo.getMarkList();
		List<BtechChemEntity> chemEntityList = new ArrayList<>();
		Map<String,BtechChemEntity> map = new LinkedHashMap<>();
		for(SubMarkVO subMark : markList) {
			BtechChemEntity btechChemEntity =	chemRepo.findByStudId(subMark.getStudId());
			if(null==btechChemEntity) {
				 btechChemEntity = new BtechChemEntity();
			}
			
			btechChemEntity.setStudId(subMark.getStudId());
			switch(markVo.getSemster()) {
			
			case "s1" : btechChemEntity.setS1(subMark.getMark());
						break;
						
			case "s2" : btechChemEntity.setS2(subMark.getMark());
						break;	
						
			case "s3" : btechChemEntity.setS3(subMark.getMark());
						break;
			}
			chemEntityList.add(btechChemEntity);
		}
		
		if(CollectionUtils.isNotEmpty(chemRepo.saveAll(chemEntityList))) {
			return true;
		}
		return false;
	}

	private boolean addPhy(MarkVO markVo) {
		List<SubMarkVO> markList = markVo.getMarkList();
		List<BtechPhyEntity> phyEntityList = new ArrayList<>();
		
		for(SubMarkVO subMark : markList) {
			BtechPhyEntity btechPhyEntity =	phyRepo.findByStudId(subMark.getStudId());
			if(null==btechPhyEntity) {
				btechPhyEntity = new BtechPhyEntity();
			}
			btechPhyEntity.setStudId(subMark.getStudId());
			switch(markVo.getSemster()) {
			
			case "s1" : btechPhyEntity.setS1(subMark.getMark());
						break;
						
			case "s2" : btechPhyEntity.setS2(subMark.getMark());
						break;	
						
			case "s3" : btechPhyEntity.setS3(subMark.getMark());
						break;
			}
			phyEntityList.add(btechPhyEntity);
		}
		
		if(CollectionUtils.isNotEmpty(phyRepo.saveAll(phyEntityList))) {
			return true;
		}
		return false;
	}
	

	private boolean addMat(MarkVO markVo) {
		List<SubMarkVO> markList = markVo.getMarkList();
		List<BtechMatEntity> matEntityList = new ArrayList<>();

		for (SubMarkVO subMark : markList) {
			BtechMatEntity btechMatEntity =	matRepo.findByStudId(subMark.getStudId());
			if(null==btechMatEntity) {
				btechMatEntity = new BtechMatEntity();
			}
			btechMatEntity.setStudId(subMark.getStudId());
			switch (markVo.getSemster()) {

			case "s1":
				btechMatEntity.setS1(subMark.getMark());
				break;

			case "s2":
				btechMatEntity.setS2(subMark.getMark());
				break;

			case "s3":
				btechMatEntity.setS3(subMark.getMark());
				break;
			}
			matEntityList.add(btechMatEntity);
		}

		if (CollectionUtils.isNotEmpty(matRepo.saveAll(matEntityList))) {
			return true;
		}
		return false;
	}


	public BtechPersonelEntity updatePersonelDatas(String personelID,BtechVO btechVo) {
		
		BtechPersonelEntity btechPersonelEntity =prsnlRepo.findByPersonelId(personelID);
		if(null!=btechPersonelEntity) {
			
			if(btechVo.getPhoneNum() >0) {
				btechPersonelEntity.setPhoneNum(btechVo.getPhoneNum());
			}
			if(btechVo.getDest()!=null && "".equals(btechVo.getDest())) {
				btechPersonelEntity.setDest(btechVo.getDest());
			}
			if(btechVo.getAge() > 0) {
				btechPersonelEntity.setAge(btechVo.getAge());
			}
			
			return prsnlRepo.save(btechPersonelEntity);
		}
		
		return null;
	}


	public StudentVO getUserDeatils(String personId,String subject) {
		
		StudentVO studnt = null;
		
		switch(subject) {
		
		case "mat" : 
					 studnt =	prsnlRepo.getStudentDetails(personId);
					 break;
					 
		case "phy" : studnt = prsnlRepo.getStudentDetailsPhy(personId);
					 break;	
					 
		case "chem" : studnt = prsnlRepo.getStudentDetailsChem(personId);
						break;
		}
		
		
		if(null!=studnt) {
			return studnt;
		}
		return null;
	}

	
	public String testJpa() {
		
	//	matRepo.findByS1GreaterThan(s1);
		return null;
	}
}
