package com.smu.service.impl;

import com.smu.dao.IUserDAO;
import com.smu.model.Teacher;
import com.smu.service.IUserService;

import java.util.List;

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
	public Teacher getTeacherByTId(String TId){
		return userDAO.getTeacherByTId(TId);
	}
	public List getAllTeachers(){
		return userDAO.getAllTeachers();
	};
	public boolean addOneTeacher(Teacher t){
		return userDAO.addOneTeacher(t);
	}
	public boolean deleteOneTeacher(String TId){
		return userDAO.deleteOneTeacher(TId);
	}
	public boolean checkTeacherId(String TId){
		return userDAO.checkTeacherId(TId);
	}
	public boolean updateOneTeacherName(String TId,String TName){
		return userDAO.updateOneTeacherName(TId,TName);
	}
}
