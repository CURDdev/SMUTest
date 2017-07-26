package com.smu.service;

import java.util.List;

import com.smu.model.Score;

public interface IScoreService {
public boolean addScore(Score score);
public List gainScore(String s_no,int st_id);
public List getStationScore(String st_id);
    public List getUncommitedScoresByTId(String t_id);
    /** 通过考试 ID 和教师 ID 查找还没有最终提交的学生成绩 */
    public List getUncommitedScoreByTestIdAndTId(int testId,String t_id);
    public Score getUncommitedScoreByScoreId(int scoreId);
    public boolean commitScore(int scoreId);
    /** 修改一条还未最终提交的成绩*/
    public boolean updateScore(int scoreId,String score,Double totalScore);
    public List getScoreBySNoAndCId(String s_no,int c_id);
}
