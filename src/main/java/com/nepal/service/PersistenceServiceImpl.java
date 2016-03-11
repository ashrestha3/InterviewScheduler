package com.nepal.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nepal.beans.Vendor;

@Service
public class PersistenceServiceImpl implements PersistenceService {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> listEntity(Class<T> entityClass) {
		return getSession().createCriteria(entityClass).list();
	}
	public void addEntity(Object entity) {
		getSession().save(entity);
	}
	
	public void deleteEntity(Object entity) {
		 getSession().delete(entity);	
				
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> entityClass, Long id) {
		return (T)getSession().get(entityClass, id);
	}

	
}
