package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.dao.ICaseDAO;
import com.smu.model.Case;
import com.smu.model.Requirement;

public class CaseDAO implements ICaseDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List getCases(String st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Case as c where c.station.stId ='"+st_id+"'");
		List cases = query.list();
		ts.commit();
		session.close();
		return cases;
	}
	public Case getOneCase(String c_name){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Case as c where c.CName ="+"'"+c_name+"'";
		Query query = session.createQuery(q);
		Case cas = (Case)query.uniqueResult();
		
		ts.commit();
		session.close();
		return cas;
	}
	public boolean deleteCase(String c_name){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "delete Case as c where c.CName ="+"'"+c_name+"'";
		Query query = session.createQuery(q);
		query.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
    public boolean addCase(Case c){
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(c);	
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
    }

}
