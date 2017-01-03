package com.smu.dao;
import java.util.List;

import com.smu.model.Station;
public interface IStationDAO {
public List gainAllStations(int test_id);
public int addStation(Station s);
public Station getOneStation(int st_id);
}
