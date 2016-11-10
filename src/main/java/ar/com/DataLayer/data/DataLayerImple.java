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

@org.springframework.stereotype.Repository
public class DataLayerImple<T>implements Repository {
	
	
	private HibernateTemplate hibernateTemplate = null;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Object> ReadAll(Class obj) {
		return (List<Object>) hibernateTemplate.loadAll(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Object t) {
		hibernateTemplate.save(t);
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public Object ReadOne(Class t, Serializable id) throws Exception{
		Object obj=null;
		obj=hibernateTemplate.get(t, id);
		if(obj == null) throw new Exception();
		else{return obj;}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object t) {
		hibernateTemplate.update(t);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object> GetAllByField(Object t,String field, Serializable id) {
		String query= "from " + t.getClass() + "where " + field +"= ?";
		Serializable[] param = {id};
		List<Object> obj= hibernateTemplate.find(query,param);
		return obj;
	}

	@Override
	public List<Object> ExecuteQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
