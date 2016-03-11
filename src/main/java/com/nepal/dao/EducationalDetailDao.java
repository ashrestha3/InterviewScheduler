package com.nepal.dao;

import java.util.List;

import com.nepal.beans.EducationDetail;
import com.nepal.dto.EducationDetailDto;

public interface EducationalDetailDao {
	void addEducationDetail(EducationDetail educationDetail);
	void deleteEducationDetail(EducationDetail educationDetail);
	EducationDetail getEducationDetailById(Long id);
}
