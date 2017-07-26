package com.smu.action;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.ServletActionContext;
import com.smu.service.ITestService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.model.Test;
public class TestAction extends ActionSupport{
	private ITestService testService;
	private int TId;
	private String result;
	public ITestService getTestService() {
		return testService;
	}
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	public int getTId() {
		return TId;
	}

	public void setTId(int TId) {
		this.TId = TId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String showTests() throws Exception{
		List tests = testService.gainTests();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("tests", tests);
		return SUCCESS;
	}
	public String getPreTests() throws Exception{
		List tests = testService.getPreTests();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("tests", tests);
		return SUCCESS;
	};
	public String getLaterTests() throws Exception{
		List tests = testService.getLaterTests();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("tests", tests);
		return SUCCESS;
	};
	public String deleteTests() throws Exception{
		Map<String,String > map = new HashMap<String,String>();
		if(testService.deleteTests(TId)) {
			map.put("result","ok");
		}
		result = JSON.toJSONString(map);
		return SUCCESS;
	};
	public String getOneTestClasses() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Test t = testService.getOneTest(TId);
		String classesString = t.getClassName();
		System.out.println(classesString);
		map.put("result",classesString);
		result  = JSON.toJSONString(map);
		System.out.println(result);
		return SUCCESS;
	}
}
