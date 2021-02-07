package com.example.btech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.btech.VO.StudentVO;
import com.example.btech.entity.BtechPersonelEntity;

@Repository
public interface BtechPrsnlRepo extends JpaRepository<BtechPersonelEntity, String> {

	public BtechPersonelEntity findByPersonelId(String personId);
	
	@Query("Select new com.example.btech.VO.StudentVO(c.username ,c.age , c.phoneNum ,c.personelId , m.s1 , m.s2 ,m.s3, m.s4) from BtechPersonelEntity c INNER JOIN  BtechMatEntity m ON c.personelId = m.studId where m.studId = :prsnId" )
	public StudentVO getStudentDetails(@Param("prsnId") String personelId);
	
	@Query("Select new com.example.btech.VO.StudentVO(c.username ,c.age , c.phoneNum ,c.personelId , p.s1 , p.s2 ,p.s3, p.s4) from BtechPersonelEntity c INNER JOIN  BtechPhyEntity p ON c.personelId = p.studId where p.studId = :prsnId" )
	public StudentVO getStudentDetailsPhy(@Param("prsnId") String personelId);
	
	@Query("Select new com.example.btech.VO.StudentVO(c.username ,c.age , c.phoneNum ,c.personelId , p.s1 , p.s2 ,p.s3, p.s4) from BtechPersonelEntity c INNER JOIN  BtechChemEntity p ON c.personelId = p.studId where p.studId = :prsnId" )
	public StudentVO getStudentDetailsChem(@Param("prsnId") String personelId);
	

}
