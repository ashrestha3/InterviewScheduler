package com.nepal.dao;

import java.util.List;

import com.nepal.beans.Consultant;

public interface ConsultantDao {
	
	//Read Consultants
	List<Consultant> getAllConsultant();
	void addConsultant(Consultant consultant);
	void deleteConsultant(Consultant consultant);

}
