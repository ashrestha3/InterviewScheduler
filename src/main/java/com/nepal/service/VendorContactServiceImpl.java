package com.nepal.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.beans.VendorContact;

@Service
public class VendorContactServiceImpl implements VendorContactService{
	@Autowired
	PersistenceService persistenceService;

	@Transactional
	public List<VendorContact> listVendorContacts(){
		return (List<VendorContact>)persistenceService.listEntity(VendorContact.class);
	}
	
}