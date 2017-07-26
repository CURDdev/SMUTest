package com.smu.action;

import java.util.*;
import java.util.logging.LogManager;

import com.smu.model.Class;
import com.smu.service.IClassService;
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
   private IClassService classService;
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

	public IClassService getClassService() {
		return classService;
	}

	public void setClassService(IClassService classService) {
		this.classService = classService;
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
	List<Class> classes = classService.getAllClasses();
	Set<Integer> grade = new HashSet<Integer>();
	Set<String> className = new HashSet<String>();


	for(int i = 0;i<=classes.size()-1;i++){
		grade.add(Integer.parseInt(classes.get(i).getClassName().substring(0,4)));
		className.add(classes.get(i).getClassName().substring(4));
	}
	int n = grade.size();
	Integer[] a = new Integer[n];

	Map<String,String> grades = new HashMap<String, String>();
	Map<String,String> classNames = new HashMap<String, String>();
	int m = 0;
	for(Iterator<Integer> iterator = grade.iterator();iterator.hasNext();){
//		String k = iterator.next().toString();
//		grades.put(k,k);
		a[m] = iterator.next();
		m++;
	}
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - 1; j++) {
			if (a[j] > a[j + 1]) {
				int temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		}
	}
	for(int i = 0;i<=n-1;i++){
		grades.put(a[i].toString(),a[i].toString());
	}
	for(Iterator<String> iterator = className.iterator();iterator.hasNext();){
		String k = iterator.next().toString();
		classNames.put(k,k);
	}
//	for(int j = 0;j<=grade.size()-1;j++){
//		grades.put(grade[j],classes.get(j).getClassName().substring(0,4));
//		classNames.put(classes.get(j).getClassName().substring(4),classes.get(j).getClassName().substring(4));
//	}
	requestMap.put("grades",grades);
	requestMap.put("classNames",classNames);
	requestMap.put("cases", map);
	return SUCCESS;
}
public String showOneCase() throws Exception{
	CaseStore cas = new CaseStore();
	cas = caseStoreService.getOneCase(c_id);
	RequirementStore r = requirementStoreService.getAllRequirements(c_id);
	int RId = r.getRId();
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
	requestMap.put("RId",RId);
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
/** 显示目前案例库中所有的案例*/
public String showAllCases() throws Exception{
	List cases = caseStoreService.getCases();
	Map requestMap = (Map) ActionContext.getContext().get("request");
	requestMap.put("cases",cases);
	return SUCCESS;
}
/**修改题库中的一个案例*/
public String updateOneCaseStore() throws Exception{
	caseStoreService.updateOneCaseStore(caseStore.getCId(),caseStore.getCName(),caseStore.getCContent());
	requirementStoreService.updateRequirementStore(requirementStore.getRId(),requirementStore.getRName(),requirementStore.getRContent(),requirementStore.getRScore(),requirementStore.getErrors());
	return SUCCESS;
}
public String deleteOneCase() throws Exception{
	caseStoreService.deleteCase(c_id);
	String result = "ok";
	return SUCCESS;
}
}
