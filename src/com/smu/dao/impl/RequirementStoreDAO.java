
package com.smu.dao.impl;
import java.util.List;

import org.hibernate.*;

import com.smu.dao.IRequirementStoreDAO;
import com.smu.model.RequirementStore;
public class RequirementStoreDAO implements IRequirementStoreDAO {
	private SessionFactory sessionFactory;
  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    public RequirementStore getAllRequirements(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from RequirementStore as r where r.caseStore.CId ="+c_id;
		Query query = session.createQuery(q);
		RequirementStore requirement = (RequirementStore)query.uniqueResult();
		
		ts.commit();
		session.close();
		return requirement;
	}
	public boolean updateRequirementStore(int RId,String RName,String RContent,String RScore){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update RequirementStore as r set r.RName = '" + RName + "',r.RContent = '"+ RContent+"',r.RScore = '"+ RScore +"' where r.RId="+RId;
		Query queryupdate=session.createQuery(hql);
		queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	};
	public boolean updateStoreErrors(int r_id,String errors){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update RequirementStore as r set r.errors = '" +errors + "' where r.RId="+r_id;
		Query queryupdate=session.createQuery(hql);
		queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
	public RequirementStore getOneRequirementStore(int r_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from RequirementStore as r where r.RId ="+r_id;
		Query query = session.createQuery(q);
		RequirementStore requirement = (RequirementStore)query.uniqueResult();
		ts.commit();
		session.close();
		return requirement;
	}
	public boolean addRequirement(RequirementStore r){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(r);	
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	};
	public boolean updateRequirement(RequirementStore r){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql="update Requirement r set user.age=20 where r.CName=18";
		Query queryupdate=session.createQuery(hql);
		int ret=queryupdate.executeUpdate();
		ts.commit();
		session.close();
		return true;
	}
	public boolean deleteRequirement(int c_id){
		return true;
	}
}