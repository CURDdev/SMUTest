package com.smu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.smu.model.Case;
import com.smu.model.Requirement;
import com.smu.service.ICaseService;
import com.smu.service.IRequirementService;
import com.smu.util.Require;

public class CaseAction extends ActionSupport {
   private ICaseService caseService;
   private IRequirementService requirementService;
   private String stc_id;
   private String c_id;
   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseAction.class);
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
public String getStc_id() {
	return stc_id;
}
public void setStc_id(String stc_id) {
	this.stc_id = stc_id;
}
public String getC_id() {
	return c_id;
}
public void setC_id(String c_id) {
	this.c_id = c_id;
}
public String showCases() throws Exception{
	List cases = caseService.getCases(stc_id);
	Map requestMap = (Map) ActionContext.getContext().get("request");
	LOGGER.info(cases.toString());
	requestMap.put("cases", cases);
	return SUCCESS;
}
public String showOneCase() throws Exception{
	Case cas = new Case();
	cas = caseService.getOneCase(c_id);
	Requirement r = requirementService.getAllRequirements(cas.getCName());
	String stId = cas.getStation().getStId();

	String rcontent = r.getRContent();
	String rscore = r.getRScore();
	String name = r.getRName();
	String[] contents = rcontent.split(",");
	String[] scores = rscore.split(",");
	String[] names = name.split(","); 
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
	return SUCCESS;
}
}
