package com.nepal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.SalesRepresentative;
import com.nepal.dao.SalesRepresentativeDao;
import com.nepal.dto.SalesRepDto;

@Service
public class SalesRepServiceImpl implements SalesRepService {

	@Autowired
	SalesRepresentativeDao salesRepDao;

	@Autowired
	PersistenceService persistenceService;

	@Transactional
	public List<SalesRepDto> getAllSalesReps(){
		List<SalesRepresentative> salesReps = (List<SalesRepresentative>)persistenceService.listEntity(SalesRepresentative.class);
		List<SalesRepDto> salesRepDtos = new ArrayList<SalesRepDto>();
		for (SalesRepresentative reps: salesReps){
			SalesRepDto salesRepDto = new SalesRepDto();
			salesRepDto.setRepName(reps.getName());
			salesRepDto.setEmail(reps.getEmail());
			salesRepDto.setPhone(reps.getPhone());
			salesRepDtos.add(salesRepDto);
		}
		return salesRepDtos;
	}

}
