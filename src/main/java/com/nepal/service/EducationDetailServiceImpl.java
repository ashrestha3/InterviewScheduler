package com.nepal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.EducationDetail;
import com.nepal.dto.EducationDetailDto;

@Service
public class EducationDetailServiceImpl implements EducationDetailService {
	@Autowired
	PersistenceService persistenceService;
	@Transactional
	public EducationDetailDto getEducationDetailById(Long id){
		EducationDetailDto educationDetailDto = null;
		if (id != null) {
			EducationDetail educationDetail = persistenceService.get(EducationDetail.class, id);
			if (educationDetail != null) {
				educationDetailDto = new EducationDetailDto();
				educationDetailDto.setInstitutionName(educationDetail.getInstitutionName());
				educationDetailDto.setGraduateYear(educationDetail.getGraduateYear());
				educationDetailDto.setLocation(educationDetail.getLocation());
			}
		}
		return educationDetailDto;
	}


}
