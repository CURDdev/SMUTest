package com.smu.dao;

import java.util.List;

import com.smu.model.Score;

public interface IScoreDAO {
public boolean addScore(Score score);
public List getScore(String s_no,String st_id);
}
