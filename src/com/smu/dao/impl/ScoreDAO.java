
package com.smu.dao.impl;

import java.io.Console;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.jdbc.log.Log;
import com.opensymphony.xwork2.util.logging.Logger;
import com.smu.dao.IScoreDAO;
import com.smu.model.Score;
import org.apache.*;
public class ScoreDAO implements IScoreDAO{
	
private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
	return sessionFactory;
}
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
	
	
	@Override
	public boolean addScore(Score score) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(score);	
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		
		return true;
	}
	public List getScore(String s_no,String st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.station.stId ='"+st_id+"' and s.student.SNo='"+s_no+"'");
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
	public List getStationScore(String st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.station.stId ='"+st_id+"'");
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
	
}
