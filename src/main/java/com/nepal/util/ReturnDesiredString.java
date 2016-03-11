package com.nepal.util;


import java.util.HashMap;
import java.util.List;

import com.nepal.beans.VendorContact;
import com.nepal.service.VendorContactService;

public class ReturnDesiredString{
	
	public static HashMap<String,String> GetThoseMofos(VendorContactService vcs){
		System.out.println("inside getthosemofos");
		List<VendorContact> vendorContacts = vcs.listVendorContacts();
		HashMap<String, String> vContacts = new HashMap<String, String>();
		if (vendorContacts !=null){
			for (VendorContact veconts : vendorContacts){
				System.out.println("Vendor from vc \n" + veconts.getVendor());
				String vNameKey = veconts.getVendor().getVendorName();
				String vContactValueNxt=veconts.getName();
				if (vContacts.get(vNameKey)!=null){
					String vContactValuePre = vContacts.get(vNameKey);
					vContacts.put(vNameKey, vContactValuePre + "|" + vContactValueNxt);
				} else {
					vContacts.put(vNameKey, vContactValueNxt);

				}
			}
		}
		return vContacts;
	}
}