package com.nepal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Vendor;
import com.nepal.service.PersistenceService;

@Repository
public class VendorDaoImpl implements VendorDao {

	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public List<Vendor> getAllVendors() {
		Query query = persistenceService.getSession().getNamedQuery("getAllVendors");
        @SuppressWarnings("unchecked")
		List<Vendor> vendorList = (List<Vendor>)query.list();
		return vendorList;
	}

	@Transactional
	public void deleteVendor(Vendor vendor) {
		persistenceService.deleteEntity(vendor);	
	}
	@Transactional
	public void addVendor(Vendor vendor) {
		persistenceService.addEntity(vendor);
	}

}
