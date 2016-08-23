package com.smu.action;

import java.util.Map;

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
    String error = "error";
	Teacher user1 = userService.checkUser(teacher);
	if(user1!=null)	
	{session.put("user",user1);
	return SUCCESS;	}
	else
	{
		session.put("error", error);
		return ERROR;
	}

}
public String logOut() throws Exception
{
	Map session=(Map) ActionContext.getContext().getSession();
	
	session.remove("user");
	return SUCCESS;		
}


}
