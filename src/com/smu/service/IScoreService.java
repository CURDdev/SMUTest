package com.smu.service;

import java.util.List;

import com.smu.model.Score;

public interface IScoreService {
public boolean addScore(Score score);
public List gainScore(String s_no,String st_id);
public List getStationScore(String st_id);
}
