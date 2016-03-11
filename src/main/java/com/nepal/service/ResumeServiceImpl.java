package com.nepal.service;

import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;

@Service
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public Blob getResumeById(Long id){
		Blob resume = null;
		if (id != null) {
			Consultant getResume = persistenceService.get(Consultant.class, id);
			
			if (getResume != null) {
				
				resume=(getResume.getResumeDocu());
				System.out.println("you got the blob from service" + resume);
				
			}
		}
		return resume;
	}
	
	@Transactional
	public byte[] getResumeById(Long id, boolean toByteArray){
		Blob resume = getResumeById(id);
		byte[] byteResume = null;
		if (toByteArray) {
			long posi = 1;
			int resumeLength = 0;
			if (resume != null) {
				try {
					resumeLength = Integer.valueOf(String.valueOf(resume.length()));
					byteResume = resume.getBytes(posi, resumeLength);//convert resume blob to ResponseEntity<byte[]>
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//and return it
			}
		}
		return byteResume;
	}
	
}
