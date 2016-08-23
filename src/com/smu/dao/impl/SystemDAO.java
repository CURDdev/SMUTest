package com.smu.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.dao.ISystemDAO;
import com.smu.dao.IUserDAO;
import com.smu.model.System;

public class SystemDAO implements ISystemDAO{
private SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
public System checkAdmin(System admin){
	Session session = sessionFactory.openSession();
	Transaction ts = session.beginTransaction();
	String q = "from System as t where t.TId ="+"'"+admin.getAdminId()+"' "+"and t.TPassword = "+"'"+admin.getAdminPassword()+"'";
	Query query = session.createQuery(q);
    System admin1 = new System();
	List list = query.list();
	ts.commit();
	session.clear();
	session.close();
	if (list.size() != 0) {
		admin1 = (System) list.get(0);
		return admin1;
	}
	return null;

}
}
