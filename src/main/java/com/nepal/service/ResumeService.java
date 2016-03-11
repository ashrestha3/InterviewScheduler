package com.nepal.service;

import java.sql.Blob;


public interface ResumeService {
	Blob getResumeById(Long id);
	byte[] getResumeById(Long id, boolean getResponseEntity);
}
