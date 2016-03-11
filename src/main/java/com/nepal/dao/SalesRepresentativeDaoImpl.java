package com.nepal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.SalesRepresentative;
import com.nepal.service.PersistenceService;

@Repository
public class SalesRepresentativeDaoImpl implements SalesRepresentativeDao {

	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public List<SalesRepresentative> getAllSalesRepresentatives() {

		return listSalesRepresentative();
	}
	
	@Transactional
	public List<SalesRepresentative> listSalesRepresentative(){
		return (List<SalesRepresentative>) persistenceService.listEntity(SalesRepresentative.class);	
	}
	
	public void addSalesRepresentative(SalesRepresentative salesRepresentative) {
		persistenceService.addEntity(salesRepresentative);

	}

	public void deleteSalesRepresentative(SalesRepresentative salesRepresentative) {
		persistenceService.deleteEntity(salesRepresentative);

	}
	

}
