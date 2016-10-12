package ar.com.DataLayer.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.com.Hibernate.*;


public class ReadDataLayerImple implements ReadDataLayer {
	
	private Session session = HibernateUtil.getSession();
	private static ReadDataLayerImple instance;
	private List<Object> object;
	public static ReadDataLayerImple getInstance() {
		if (instance == null)
			instance = new ReadDataLayerImple();
		return instance;
	}
	
	@Override
	public List<Object> ReadAll(Class clazz) {
		try {
			object=session.createCriteria(clazz).list();
			HibernateUtil.shutdown();
			return object;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return object;
	}

	@Override
	public void ReadOne(Class clazz, Serializable id) {
		
		
	}

}
