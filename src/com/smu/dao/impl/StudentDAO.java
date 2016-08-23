package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.dao.IScoreDAO;
import com.smu.dao.IStudentDAO;
import com.smu.model.Requirement;
import com.smu.model.Student;
import com.smu.model.Teacher;

public class StudentDAO implements IStudentDAO {
    private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    public boolean checkStudent(String s_no){
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Student as s where s.SNo ="+"'"+s_no+"'";
		Query query = session.createQuery(q);
	    List list = query.list();
			ts.commit();
			session.clear();
			session.close();
			if (list.size() != 0) {
				
				return true;
			}
			return false;
    	
    }
    public List getStudentsByClass(String class_name) {
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Student as s where s.className.className ="+"'"+class_name+"'");
		List students = query.list();
		ts.commit();
		session.close();
		return students;
		
	}
}
