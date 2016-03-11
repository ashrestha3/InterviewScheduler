package com.nepal.dao;

import java.util.List;

import com.nepal.beans.Interview;

public interface InterviewDao {

	List <Interview> getAllInterview();
	void addInterview(Interview interview);
	void deleteInterview(Interview interview);
}
