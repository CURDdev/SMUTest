package com.smu.dao.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.action.UserAction;
import com.smu.dao.IUserDAO;
import com.smu.model.Teacher;

public class UserDAO implements IUserDAO{
private SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
public Teacher checkUser(Teacher teacher){
	Session session = sessionFactory.openSession();
	Transaction ts = session.beginTransaction();
	String q = "from Teacher as t where t.TId ="+"'"+teacher.getTId()+"' "+"and t.TPassword = "+"'"+teacher.getTPassword()+"'";
	Query query = session.createQuery(q);
    Teacher user1 = new Teacher();
	List list = query.list();
	ts.commit();
	session.clear();
	session.close();
	if (list.size() != 0) {
		user1 = (Teacher) list.get(0);
		
		return user1;
	}
	return null;

}
}
