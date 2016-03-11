package com.nepal.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Client;
import com.nepal.beans.Consultant;
import com.nepal.beans.ConsultantClient;
import com.nepal.beans.EducationDetail;
import com.nepal.beans.Interview;
import com.nepal.beans.SalesRepresentative;
import com.nepal.beans.Vendor;
import com.nepal.dto.ConsultantDto;
import com.nepal.dto.SalesRepDto;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	PersistenceService persistenceService; 

	@Transactional
	public void addConsultant(ConsultantDto consultant) {
		Consultant newConsultant = new Consultant();
		newConsultant.setName(consultant.getName());
		newConsultant.setDob(consultant.getDob());
		newConsultant.setEmail("me@me.com");
		newConsultant.setPhone("7209801589");
		newConsultant.setSsn("45454545");
		SalesRepresentative rep = persistenceService.get(SalesRepresentative.class, 1L);
		newConsultant.setSalesRep(rep);
		newConsultant.setYrsExp(6.5);
		
	}

	@Transactional
	public Consultant getConsultantById(Long id) {
		Consultant consultant = persistenceService.get(Consultant.class, id);
		return consultant;
	}

	@Transactional
	public List<ConsultantDto> getAllConsultants(){
		List<Consultant> consultants = (List<Consultant>)persistenceService.listEntity(Consultant.class);
		List<ConsultantDto> consultantDtos= new ArrayList<ConsultantDto>();
		
		System.out.println("We are in process of getting Consultants");
		for (Consultant cons : consultants){
			System.out.println("Getting Another");
			ConsultantDto consultantDto = new ConsultantDto();
			consultantDto.setId(cons.getId());
			consultantDto.setName(cons.getName());
			consultantDto.setEmail(cons.getEmail());
			consultantDto.setDob(cons.getDob());
			consultantDto.setPhone(cons.getPhone());
			consultantDto.setYearsExp(cons.getYrsExp());
			consultantDto.setSsn(cons.getSsn());
			SalesRepresentative salesRep = cons.getSalesRep();
			//new sales rep dto
			SalesRepDto salesRepDto = new SalesRepDto();			
			//set fields
			salesRepDto.setRepName(salesRep.getName());
			salesRepDto.setPhone(salesRep.getPhone());
			salesRepDto.setEmail(salesRep.getEmail());
			//set salesrepdto with newly create sales rep dto
			consultantDto.setSalesRepDto(salesRepDto);
			consultantDto.setEducationName(cons.getEducationDetail().getInstitutionName());
			consultantDtos.add(consultantDto);
			System.out.println("One Consultant down");
		}
		return consultantDtos;
	}


}
