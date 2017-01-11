package com.smu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import com.smu.model.*;
import com.smu.service.IStudentService;
import com.smu.service.ITestService;
import org.apache.log4j.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.smu.service.ICaseService;
import com.smu.service.IRequirementService;
import com.smu.util.Require;

public class CaseAction extends ActionSupport {
   private ICaseService caseService;
   private IRequirementService requirementService;
   private int stc_id;
   private int c_id;
   private  int t_id;
   private IStudentService studentService;
   private ITestService iTestService;
   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseAction.class);

	public ITestService getiTestService() {
		return iTestService;
	}

	public void setiTestService(ITestService iTestService) {
		this.iTestService = iTestService;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public IRequirementService getRequirementService() {
	return requirementService;
}
public void setRequirementService(IRequirementService requirementService) {
	this.requirementService = requirementService;
}
public ICaseService getCaseService() {
	return caseService;
}
public void setCaseService(ICaseService caseService) {
	this.caseService = caseService;
}
public int getStc_id() {
	return stc_id;
}
public void setStc_id(int stc_id) {
	this.stc_id = stc_id;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public String showCases() throws Exception{
	List cases = caseService.getCases(stc_id);
	Map requestMap = (Map) ActionContext.getContext().get("request");
	LOGGER.info(cases.toString());
	requestMap.put("cases", cases);
	requestMap.put("t_id",t_id);
	return SUCCESS;
}
public String showOneCase() throws Exception{
	Case cas = new Case();
	cas = caseService.getOneCase(c_id);
	Requirement r = requirementService.getAllRequirements(cas.getCId());
	int stId = cas.getStation().getStId();
	Test ttt = new Test();
	ttt = iTestService.getOneTest(t_id);
	String gradeClassName = ttt.getClassName();
	String[] className = gradeClassName.split(",");




	List<Student> students = new ArrayList<Student>();
	for(int m = 0;m<=className.length-1;m++) {

	 students.addAll(studentService.getStudentsByClass(className[m]));
	}
	Map map = new HashMap<>();
	for(int i = 0;i<students.size();i++){
		map.put(students.get(i).getSNo(), students.get(i).getSName()+students.get(i).getSNo());
	}







	String rcontent = r.getRContent();
	String rscore = r.getRScore();
	String name = r.getRName();
	String[] contents = rcontent.split("/");
	String[] scores = rscore.split("/");
	String[] names = name.split("/"); 
	List<Require> r_list = new ArrayList<Require>();
	
	for(int i = 1;i<= scores.length-1;i++){
		Require require = new Require();
		require.setContent(contents[i]);
		require.setScore(scores[i]);
		require.setName(names[i]);
		r_list.add(require);
	}
	Map requestMap = (Map) ActionContext.getContext().get("request");
	requestMap.put("stId",stId);
	requestMap.put("CId", c_id);
	requestMap.put("require", r_list);
	requestMap.put("RName",names[0]);
	requestMap.put("RContent",contents[0]);
	requestMap.put("RScore",scores[0]);
	requestMap.put("case", cas);
	requestMap.put("students", map);
	return SUCCESS;
}
}
