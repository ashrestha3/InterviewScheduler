package com.nepal.dao;

import java.time.Year;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.beans.EducationDetail;
import com.nepal.service.PersistenceService;

@Repository
public class ConsultantDaoImpl implements ConsultantDao {

	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public List<Consultant> getAllConsultant() {
		return listConsultants();
	}

	@Transactional
	public List<Consultant> listConsultants(){
		return (List<Consultant>)persistenceService.listEntity(Consultant.class);
	}
	
	@Transactional
	public void addConsultant(Consultant consultant) {
		persistenceService.addEntity(consultant);	
	}

	@Transactional
	public void deleteConsultant(Consultant consultant) {
		persistenceService.deleteEntity(consultant);
	}

}
