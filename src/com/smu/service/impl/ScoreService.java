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
	public List gainScore(String s_no,int st_id){
		return scoreDAO.getScore(s_no, st_id);
	}
    public List getStationScore(String st_id){
	    return scoreDAO.getStationScore(st_id);
    }
	public List getUncommitedScoresByTId(String t_id){return scoreDAO.getUncommitedScoresByTId(t_id);}
	/** 通过考试 ID 和教师 ID 查找还没有最终提交的学生成绩 */
	public List getUncommitedScoreByTestIdAndTId(int testId,String t_id){
		return scoreDAO.getUncommitedScoreByTestIdAndTId(testId,t_id);
	}
	public Score getUncommitedScoreByScoreId(int scoreId){
		return scoreDAO.getUncommitedScoreByScoreId(scoreId);
	}
	public boolean commitScore(int scoreId){
		return  scoreDAO.commitScore(scoreId);
	}
	public boolean updateScore(int scoreId,String score,Double totalScore){
		return scoreDAO.updateScore(scoreId,score,totalScore);
	}
	public List getScoreBySNoAndCId(String s_no,int c_id){
		return scoreDAO.getScoreBySNoAndCId(s_no,c_id);
	}
}
