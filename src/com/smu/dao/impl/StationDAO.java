package com.smu.dao.impl;
import java.util.List;

import org.hibernate.*;

import com.smu.dao.IStationDAO;
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
    public List gainAllStations(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Station");
		List stations = query.list();
		ts.commit();
		session.close();
		return stations;
	}
	public boolean addStation(Station s) {
		return true;
		
	}
}
