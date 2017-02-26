
package com.smu.dao.impl;

import java.io.Console;
import java.util.List;

import com.mysql.jdbc.DocsConnectionPropsHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.jdbc.log.Log;
import com.opensymphony.xwork2.util.logging.Logger;
import com.smu.dao.IScoreDAO;
import com.smu.model.Score;
//import org.apache.*;
public class ScoreDAO implements IScoreDAO{
	
private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
	return sessionFactory;
}
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
	public boolean addScore(Score score) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(score);	
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		
		return true;
	}
	public List getScore(String s_no,int st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.station.stId ='"+st_id+"' and s.student.SNo='"+s_no+"'");
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
	public List getStationScore(String st_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.station.stId ='"+st_id+"'");
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
	public List getUncommitedScoresByTId(String t_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.teacher.TId ='"+t_id+"' and s.status ='no'");
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
	/** 通过考试 ID 和教师 ID 查找还没有最终提交的学生成绩 */
	public List getUncommitedScoreByTestIdAndTId(int testId,String t_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.teacher.TId ='"+t_id+"' and s.status ='no' and s.TId = "+ testId);
		List scores = query.list();
		ts.commit();
		session.close();
		return scores;
	}
    /** 通过成绩 id 获得一条尚未提交的成绩数据*/
	public Score getUncommitedScoreByScoreId(int scoreId) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Score as s where s.scId =" + scoreId);
		Score score = (Score) query.uniqueResult();
		ts.commit();
		session.close();
		return score;
	}
	/** 最终提交一名学生的成绩*/
	public boolean commitScore(int scoreId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update Score as s set s.status = 'yes' where s.scId="+scoreId;
		Query queryupdate=session.createQuery(hql);
		queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
	/** 修改一名学生还未提交的成绩*/
	public boolean updateScore(int scoreId,String score,Double totalScore){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update Score as s set s.scScore = '"+ score +"',s.scTotalScore ="+ totalScore +" where s.scId="+scoreId+" and s.status = 'no'";
		System.out.println(hql);
		Query queryupdate=session.createQuery(hql);
		queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
}
