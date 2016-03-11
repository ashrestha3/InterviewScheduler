package com.nepal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Interview;
import com.nepal.service.PersistenceService;

@Repository
public class InterviewDaoImpl implements InterviewDao {
	
	@Autowired
	PersistenceService persistenceService;

	@Transactional
	public List<Interview> getAllInterview() {	
		return listInterviews();
	}
	@Transactional
	public List<Interview> listInterviews(){
		return (List<Interview>)persistenceService.listEntity(Interview.class);
		
	}
	@Transactional
	public void addInterview(Interview interview) {
		persistenceService.addEntity(interview);

	}
	@Transactional
	public void deleteInterview(Interview interview) {
		persistenceService.addEntity(interview);

	}

}
