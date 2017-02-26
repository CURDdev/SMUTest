package com.smu.action;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.smu.service.ITestService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class TestAction extends ActionSupport{
	private ITestService testService;
	public ITestService getTestService() {
		return testService;
	}
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}
	public String showTests() throws Exception{
		List tests = testService.gainTests();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("tests", tests);
		return SUCCESS;
	}


}
