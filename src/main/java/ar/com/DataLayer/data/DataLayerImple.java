package ar.com.DataLayer.data;

import java.io.Serializable;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.Hibernate.*;
import ar.com.repository.Repository;


public class DataLayerImple implements Repository {
	
	private HibernateTemplate hibernateTemplate = null;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Object> ReadAll(Class clazz) {
		return hibernateTemplate.loadAll(clazz);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Object customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void ReadOne(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		
	}

}
