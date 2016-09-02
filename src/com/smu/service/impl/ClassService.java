package com.smu.service.impl;

import java.util.List;

import com.smu.dao.IClassDAO;
import com.smu.service.IClassService;

public class ClassService implements IClassService {
    private IClassDAO classDAO;

	public IClassDAO getClassDAO() {
		return classDAO;
	}

	public void setClassDAO(IClassDAO classDAO) {
		this.classDAO = classDAO;
	}
    public List getAllClasses(){
    	return classDAO.getAllClasses();
    }
}
