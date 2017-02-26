package com.smu.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.model.Class;
import com.smu.service.IClassService;
import com.smu.service.ITestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.smu.model.Test;
public class ClassAction extends ActionSupport {
    private IClassService classService;
    private ITestService testService;

	public ITestService getTestService() {
		return testService;
	}

	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

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
	public String showTestsAndClasses() throws Exception{
		List<Test> tests = testService.getAllTests();
		List<Class> classes = classService.getAllClasses();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		Map<Integer,String> testNames = new HashMap<Integer, String>();
		Map<String,String> grades = new HashMap<String, String>();
		Map<String,String> classNames = new HashMap<String, String>();
		for (int j = 0;j<=tests.size()-1;j++){
			System.out.println(tests.get(j).getTestName());
			testNames.put(tests.get(j).getTestId(),tests.get(j).getTestName());
		}
		for (int i = 0;i<=classes.size()-1;i++){
			grades.put(classes.get(i).getClassName().substring(0,5),classes.get(i).getClassName().substring(0,5));
			classNames.put(classes.get(i).getClassName().substring(5),classes.get(i).getClassName().substring(5));
		}

		requestMap.put("testNames", testNames);
		requestMap.put("grades",grades);
		requestMap.put("classNames",classNames);
		return SUCCESS;
	}
}
