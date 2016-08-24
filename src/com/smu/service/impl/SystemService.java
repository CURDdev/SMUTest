package com.smu.service.impl;

import com.smu.dao.ISystemDAO;
import com.smu.model.System;
import com.smu.service.ISystemService;

public class SystemService implements ISystemService{
private ISystemDAO systemDAO;


public ISystemDAO getSystemDAO() {
	return systemDAO;
}


public void setSystemDAO(ISystemDAO systemDAO) {
	this.systemDAO = systemDAO;
}


public System checkAdmin(System admin){
	return systemDAO.checkAdmin(admin);
}
}
