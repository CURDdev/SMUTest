package com.smu.action;

import java.util.Map;
import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.model.Teacher;

import com.smu.service.IUserService;

public class UserAction extends ActionSupport{
	
private IUserService userService;
private Teacher teacher;

public IUserService getUserService() {
	return userService;
}
public void setUserService(IUserService userService) {
	this.userService = userService;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public String checkUser() throws Exception
{
	Map session=(Map) ActionContext.getContext().getSession();
	Teacher user1 = new Teacher();
    user1 = userService.checkUser(teacher);
    if(user1 == null){
    	return ERROR;
    }
	String role = user1.getRole();
	
	if(role.equals("guest"))	
	{
		session.put("user",user1);
		
	    return SUCCESS;
	}
	else if(role.equals("admin")){
		session.put("user",user1);
		return LOGIN;
	}
	
//	else if(user1 == null)
//	{
//		session.put("error", error);
//		return ERROR;
//	}
	else
	return ERROR;

}

public String logOut() throws Exception
{
	Map session=(Map) ActionContext.getContext().getSession();
	
	session.remove("user");
	return SUCCESS;		
}

}
