package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.action.CaseAction;
import com.smu.dao.ICaseDAO;
import com.smu.model.Case;
import com.smu.model.Requirement;

public class CaseDAO implements ICaseDAO{
	private SessionFactory sessionFactory;
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseDAO.class);
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List getCases(int st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Case as c where c.station.stId ="+st_id);
		List cases = query.list();
		ts.commit();
		session.close();
		return cases;
	}
	public Case getOneCase(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Case as c where c.CId ="+c_id;
		Query query = session.createQuery(q);
		Case cas = (Case)query.uniqueResult();
		
		ts.commit();
		session.close();
		return cas;
	}
	public boolean deleteCase(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "delete Case as c where c.CId ="+c_id;
		Query query = session.createQuery(q);
		query.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
    public int addCase(Case c){
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
