package com.nepal.service;

import java.util.List;

import com.nepal.beans.Consultant;
import com.nepal.dto.ConsultantDto;


public interface ConsultantService {
	
	void addConsultant(ConsultantDto consultant);
	Consultant getConsultantById(Long id);
	List<ConsultantDto> getAllConsultants();
}
