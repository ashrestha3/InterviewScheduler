package com.nepal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.EducationDetail;
import com.nepal.beans.SalesRepresentative;
import com.nepal.dto.EducationDetailDto;
import com.nepal.service.EducationDetailService;
import com.nepal.service.PersistenceService;

public class EducationalDetailDaoImpl implements EducationalDetailDao {
	
	@Autowired
	PersistenceService persistenceService;

	@Transactional
	public void addEducationDetail(EducationDetail educationDetail){
		
	}
	@Transactional
	public void deleteEducationDetail(EducationDetail educationDetail){
		
	}
	@Transactional
	public EducationDetail getEducationDetailById(Long id) {
		return (persistenceService.get(EducationDetail.class, id));
	}
	

	

}
