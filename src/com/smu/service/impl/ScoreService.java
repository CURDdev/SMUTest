package com.smu.service.impl;

import java.util.List;

import com.smu.dao.IScoreDAO;
import com.smu.model.Score;
import com.smu.service.IScoreService;

public class ScoreService implements IScoreService {
private IScoreDAO scoreDAO;

public IScoreDAO getScoreDAO() {
	return scoreDAO;
}

public void setScoreDAO(IScoreDAO scoreDAO) {
	this.scoreDAO = scoreDAO;
}
public boolean addScore(Score score){
	return scoreDAO.addScore(score);
	
	
}
public List gainScore(String s_no,String st_id){
	return scoreDAO.getScore(s_no, st_id);
}
public List getStationScore(String st_id){
	return scoreDAO.getStationScore(st_id);
}
}
