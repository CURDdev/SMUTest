package com.smu.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.service.IClassService;

import java.util.List;
import java.util.Map;
public class ClassAction extends ActionSupport {
    private IClassService classService;

	public IClassService getClassService() {
		return classService;
	}

	public void setClassService(IClassService classService) {
		this.classService = classService;
	}
    public String showClasses() throws Exception{
    	
    	List classes = classService.getAllClasses();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("classes", classes);
		return SUCCESS;
    }
}
