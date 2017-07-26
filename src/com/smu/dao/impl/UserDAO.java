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
	public Teacher getTeacherByTId(String TId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Teacher as t where t.TId ="+"'"+TId+"'";
		Query query = session.createQuery(q);
		Teacher t = (Teacher) query.uniqueResult();
		ts.commit();
		session.close();
		return t;
	}
	public List getAllTeachers(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Teacher");
		List stations = query.list();
		ts.commit();
		session.close();
		return stations;
	}
	public boolean addOneTeacher(Teacher t){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(t);
		try {
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.close();
		}
		session.clear();
		ts.commit();
		session.close();
		return true;
	}
	public boolean deleteOneTeacher(String TId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "delete Teacher as t where t.TId = '"+TId+"'";
		Query query = session.createQuery(q);
		query.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
	public boolean checkTeacherId(String TId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Teacher as t where t.TId = '"+TId+"'");
		List teachers = query.list();
		ts.commit();
		session.close();
		if(teachers.size() == 1){
			return true;
		}
		return false;
	}
	public boolean updateOneTeacherName(String TId,String TName){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update Teacher as t set t.TName = '" +TName + "' where t.TId='"+TId+"'";
		Query queryupdate=session.createQuery(hql);
		queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
}
