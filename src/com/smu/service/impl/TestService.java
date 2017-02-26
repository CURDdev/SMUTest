package com.smu.service.impl;
import java.util.*;

import org.hibernate.*;

import com.smu.dao.ITestDAO;
import com.smu.model.Test;
import com.smu.service.ITestService;
public class TestService implements ITestService{
private ITestDAO testDAO;


public ITestDAO getTestDAO() {
	return testDAO;
}


public void setTestDAO(ITestDAO testDAO) {
	this.testDAO = testDAO;
}


@Override
public List gainTests(){
	return testDAO.gainTests();
	
	
}
public Test getOneTest(int t_id){
	return testDAO.getOneTest(t_id);
}
public int addTest(Test t){
	return testDAO.addTest(t);
};
	public List getAllTests(){
		return testDAO.getAllTests();
	};
}

