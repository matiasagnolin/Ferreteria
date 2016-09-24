package ar.com.DataLayer.data;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDataLayerImple<T> implements SaveDataLayer<T> {
	SessionFactory sessionFactory;
	@Override
	public void save(T t) {
		sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		//Transaction tx = session.getTransaction();
		try {
			//tx.begin();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			session.close();
			//tx.commit();
		} catch (Exception e) {
			//tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	

}
