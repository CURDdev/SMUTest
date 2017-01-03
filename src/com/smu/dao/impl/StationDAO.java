package com.smu.dao.impl;
import java.util.List;

import org.hibernate.*;

import com.smu.dao.IStationDAO;
import com.smu.model.Case;
import com.smu.model.Station;
public class StationDAO implements 	IStationDAO {
	private SessionFactory sessionFactory;
  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
    public List gainAllStations(int test_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Station as s where s.test.testId ="+test_id);
		List stations = query.list();
		ts.commit();
		session.close();
		return stations;
	}
	public Station getOneStation(int st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Station as s where s.stId ="+st_id;
		Query query = session.createQuery(q);
		Station st = (Station)query.uniqueResult();
		
		ts.commit();
		session.close();
		return st;
	}
	public int addStation(Station s) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	    session.save(s);
	    try {
	    	session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.close();
		}
	    int id = s.getStId();
		session.clear();
		ts.commit();
		session.close();
		return id;
		
	}
}
