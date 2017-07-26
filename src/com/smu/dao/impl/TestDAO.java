package com.smu.dao.impl;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.*;

import com.smu.action.CaseAction;
import com.smu.dao.ITestDAO;
import com.smu.model.Case;
import com.smu.model.Test;
public class TestDAO implements ITestDAO {
	private SessionFactory sessionFactory;
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(TestDAO.class);
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    public List gainTests(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Timestamp t = new Timestamp(System.currentTimeMillis());  
		LOGGER.info(t);
		Query query = session.createQuery("from Test as t where t.testBeginTime < '"+t+"' and t.testEndTime >'"+t+"'");
		List tests = query.list();
		ts.commit();
		session.close();
		return tests;
	}
	public int addTest(Test t) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	    session.save(t);
	    try {
	    	session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.close();
		}
	    int id = t.getTestId();
		session.clear();
		ts.commit();
		session.close();
		return id;
	}
   public Test getOneTest(int t_id){
	   Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Test as t where t.testId ="+t_id;
		Query query = session.createQuery(q);
		Test t = (Test)query.uniqueResult();
		
		ts.commit();
		session.close();
		return t;
   }
   public List getAllTests(){
	   Session session = sessionFactory.openSession();
	   Transaction ts = session.beginTransaction();
	   Query query = session.createQuery("from Test");
	   List tests = query.list();
	   ts.commit();
	   session.close();
	   return tests;
   }
	public List getPreTests(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Timestamp t = new Timestamp(System.currentTimeMillis());
		LOGGER.info(t);
		Query query = session.createQuery("from Test as t where t.testEndTime < '"+t+"'");
		List tests = query.list();
		ts.commit();
		session.close();
		return tests;
	}
	public List getLaterTests(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Timestamp t = new Timestamp(System.currentTimeMillis());
		LOGGER.info(t);
		Query query = session.createQuery("from Test as t where t.testBeginTime > '"+t+"'");
		List tests = query.list();
		ts.commit();
		session.close();
		return tests;
	}
	public boolean deleteTests(int t_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "delete Test as t where t.testId ="+t_id;
		Query query = session.createQuery(q);
		query.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
}
