package com.nepal.dao;

import java.util.List;

import com.nepal.beans.SalesRepresentative;

public interface SalesRepresentativeDao {

	List<SalesRepresentative> getAllSalesRepresentatives();
	void addSalesRepresentative(SalesRepresentative salesRepresentative);
	void deleteSalesRepresentative(SalesRepresentative salesRepresentative);
	

}
