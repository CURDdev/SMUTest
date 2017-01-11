package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.smu.dao.ICaseStoreDAO;
import com.smu.model.CaseStore;


public class CaseStoreDAO implements ICaseStoreDAO{
	private SessionFactory sessionFactory;
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseDAO.class);
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List getCases(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from CaseStore");
		List cases = query.list();
		ts.commit();
		session.close();
		return cases;
	}
	public CaseStore getOneCase(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from CaseStore as c where c.CId ="+c_id;
		Query query = session.createQuery(q);
		CaseStore cas = (CaseStore)query.uniqueResult();
		
		ts.commit();
		session.close();
		return cas;
	}
	public boolean deleteCase(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "delete CaseStore as c where c.CId ="+c_id;
		Query query = session.createQuery(q);
		query.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
    public int addCase(CaseStore c){
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		LOGGER.warn("1");
	    session.save(c);
	    LOGGER.warn("2");
	    try {
	    	session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.close();
		}
		int id = c.getCId();
		LOGGER.warn("4");
		session.clear();
		ts.commit();
		LOGGER.warn("5");
		session.close();
		LOGGER.warn("8");
		return id;
    }

}
