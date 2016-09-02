package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.dao.IClassDAO;

public class ClassDAO implements IClassDAO{
	private SessionFactory sessionFactory;
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
    public List getAllClasses(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Class");
		List classes = query.list();
		ts.commit();
		session.close();
		return classes;
	}
}
