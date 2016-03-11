package com.nepal.service;

import java.util.List;

import com.nepal.beans.Vendor;
import com.nepal.dto.ConsultantDto;
import com.nepal.dto.VendorDto;

public interface VendorService {
	
	List<VendorDto> getAllVendors();
}
