package com.smu.util;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.smu.model.Teacher;

public class AdminLoginIniter extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
			Map session=(Map) arg0.getInvocationContext().getSession();
			Teacher user= (Teacher) session.get("user");
			if(user!=null&&user.getRole().equals("admin")){
				System.out.println("登录身份AdminLoginIniter为管理员");
				return arg0.invoke();
			}
			System.out.println("登录身份AdminLoginIniter为客户");
			return Action.LOGIN;
	}

}
