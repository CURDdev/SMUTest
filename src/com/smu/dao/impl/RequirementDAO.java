
package com.smu.dao.impl;
import java.util.List;

import org.hibernate.*;

import com.smu.dao.IRequirementDAO;
import com.smu.model.Requirement;
public class RequirementDAO implements IRequirementDAO {
	private SessionFactory sessionFactory;
  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
    public Requirement getAllRequirements(int c_id){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String q = "from Requirement as r where r.cas.CId ="+c_id;
		Query query = session.createQuery(q);
		Requirement requirement = (Requirement)query.uniqueResult();
		
		ts.commit();
		session.close();
		return requirement;
	}
	public boolean addRequirement(Requirement r){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(r);	
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	};
	public boolean updateRequirement(Requirement r){
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