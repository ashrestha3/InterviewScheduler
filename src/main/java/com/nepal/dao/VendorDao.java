package com.nepal.dao;

import java.util.List;

import com.nepal.beans.Vendor;


public interface VendorDao {

	List<Vendor> getAllVendors();
	void deleteVendor(Vendor vendor);
	void addVendor(Vendor vendor);

}
