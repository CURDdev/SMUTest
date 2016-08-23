package com.smu.service.impl;
import java.util.*;

import org.hibernate.*;

import com.smu.dao.IStationDAO;
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
public List gainAllStations(){
	return stationDAO.gainAllStations();
	
	
}
}
