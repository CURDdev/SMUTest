package com.smu.service;
import java.util.List;

import com.smu.model.Station;
public interface IStationService {
public Station getOneStation(int st_id);
public int addStation(Station s);
public List gainAllStations(int test_id);
}
