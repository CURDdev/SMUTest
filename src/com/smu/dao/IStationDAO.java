package com.smu.dao;
import java.util.List;

import com.smu.model.Station;
public interface IStationDAO {
public List gainAllStations();
public boolean addStation(Station s);
}
