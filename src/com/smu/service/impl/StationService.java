package com.smu.service.impl;
import java.util.*;

import org.hibernate.*;

import com.smu.dao.IStationDAO;
import com.smu.model.Station;
import com.smu.service.IStationService;
public class StationService implements IStationService{
private IStationDAO stationDAO;

public IStationDAO getStationDAO() {
	return stationDAO;
}

public void setStationDAO(IStationDAO stationDAO) {
	this.stationDAO = stationDAO;
}
@Override
public List gainAllStations(int test_id){
	return stationDAO.gainAllStations(test_id);
}
public int addStation(Station s){
	return stationDAO.addStation(s);
}
public Station getOneStation(int st_id){
	return stationDAO.getOneStation(st_id);
}
}
