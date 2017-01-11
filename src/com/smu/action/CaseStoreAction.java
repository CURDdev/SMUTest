package com.smu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.log4j.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.smu.model.CaseStore;
import com.smu.model.RequirementStore;
import com.smu.service.ICaseStoreService;
import com.smu.service.IRequirementStoreService;
import com.smu.util.Require;

public class CaseStoreAction extends ActionSupport {
   private ICaseStoreService caseStoreService;
   private IRequirementStoreService requirementStoreService;
   private int c_id;
   private CaseStore caseStore;
   private RequirementStore requirementStore;
   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseAction.class);
public IRequirementStoreService getRequirementService() {
	return requirementStoreService;
}
public void setRequirementStoreService(IRequirementStoreService requirementService) {
	this.requirementStoreService = requirementService;
}

	public RequirementStore getRequirementStore() {
		return requirementStore;
	}

	public void setRequirementStore(RequirementStore requirementStore) {
		this.requirementStore = requirementStore;
	}

	public CaseStore getCaseStore() {
		return caseStore;
	}

	public void setCaseStore(CaseStore caseStore) {
		this.caseStore = caseStore;
	}

	public ICaseStoreService getCaseService() {
	return caseStoreService;
}
public void setCaseStoreService(ICaseStoreService caseService) {
	this.caseStoreService = caseService;
}

public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public String showCases() throws Exception{
	List<CaseStore> cases = new ArrayList<CaseStore>();
	cases = caseStoreService.getCases();
	Map map = new HashMap<>();
	for(int i = 0;i<cases.size();i++){
		map.put(cases.get(i).getCId(), cases.get(i).getCName());
	}
	Map requestMap = (Map) ActionContext.getContext().get("request");
	LOGGER.info(cases.toString());
	requestMap.put("cases", map);
	return SUCCESS;
}
public String showOneCase() throws Exception{
	CaseStore cas = new CaseStore();
	cas = caseStoreService.getOneCase(c_id);
	RequirementStore r = requirementStoreService.getAllRequirements(c_id);
	

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
	requestMap.put("CId", c_id);
	requestMap.put("require", r_list);
	requestMap.put("RName",names[0]);
	requestMap.put("RContent",contents[0]);
	requestMap.put("RScore",scores[0]);
	requestMap.put("case", cas);
	return SUCCESS;
}
//向题库中增加一个案例
public String addCaseStore() throws Exception{
	int id = caseStoreService.addCase(caseStore);
	requirementStore.setCaseStore(caseStoreService.getOneCase(id));
	requirementStoreService.addRequirement(requirementStore);
	return SUCCESS;
}
}
