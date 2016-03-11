package com.nepal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.EducationDetail;
import com.nepal.beans.Vendor;
import com.nepal.dto.EducationDetailDto;
import com.nepal.dto.VendorDto;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	PersistenceService persistenceService;
	@Transactional
	public List<VendorDto> getAllVendors(){
		List<Vendor> vendors = (List<Vendor>)persistenceService.listEntity(Vendor.class);
		List<VendorDto> vendorDtos= new ArrayList<VendorDto>();
		for (Vendor venkata : vendors){
			VendorDto vendorDto = new VendorDto();
			
			vendorDto.setVendorName(venkata.getVendorName());
			vendorDto.setLocation(venkata.getLocation());
						
			vendorDtos.add(vendorDto);
		}
		return vendorDtos;
	}
	
	@Transactional
	public VendorDto getVendorNameById(Long id){
		VendorDto vendorDto = null;
		if (id != null) {
			Vendor vendor = persistenceService.get(Vendor.class, id);
			if (vendor != null) {
				vendorDto = new VendorDto();
				vendorDto.setVendorName(vendor.getVendorName());
				vendorDto.setLocation(vendor.getLocation());
			}
		}
		return vendorDto;
	}



}
