package com.smu.service.impl;

import com.smu.dao.IUserDAO;
import com.smu.model.Teacher;
import com.smu.service.IUserService;

public class UserService implements IUserService{
private IUserDAO userDAO;

public IUserDAO getUserDAO() {
	return userDAO;
}

public void setUserDAO(IUserDAO userDAO) {
	this.userDAO = userDAO;
}
public Teacher checkUser(Teacher teacher){
	return userDAO.checkUser(teacher);
}
}
