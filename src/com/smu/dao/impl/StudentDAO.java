package com.smu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.smu.dao.IScoreDAO;
import com.smu.dao.IStudentDAO;
import com.smu.model.Case;
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
    public Student checkStudent(String s_no){
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Student as s where s.SNo ="+"'"+s_no+"'";
		Query query = session.createQuery(q);
		Student s = (Student)query.uniqueResult();
		
		ts.commit();
		session.close();
		return s;
    	
    }
    public List getStudentsByClass(String class_name) {
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Student as s where s.mclass.className ='"+class_name+"' order by (s.SNo+0)");
		List students = query.list();
		ts.commit();
		session.close();
		return students;
		
	}
    public List getAllStudents(){
    	
    	Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Student");
		List students = query.list();
		ts.commit();
		session.close();
		return students;
    }
}
