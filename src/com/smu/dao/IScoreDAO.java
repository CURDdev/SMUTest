package com.smu.dao;

import java.util.List;

import com.smu.model.Score;

public interface IScoreDAO {
public boolean addScore(Score score);
public List getScore(String s_no,int st_id);
public List getStationScore(String st_id);
public List getUncommitedScoresByTId(String t_id);
    /** 通过考试 ID 和教师 ID 查找还没有最终提交的学生成绩 */
    public List getUncommitedScoreByTestIdAndTId(int testId,String t_id);
    public Score getUncommitedScoreByScoreId(int scoreId);
    public boolean commitScore(int scoreId);
    public boolean updateScore(int scoreId,String score,Double totalScore);
    public List getScoreBySNoAndCId(String s_no,int c_id);
}
