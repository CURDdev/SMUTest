package com.smu.action;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.smu.model.CaseStore;
import com.smu.model.RequirementStore;
import com.smu.model.Station;
import com.smu.model.Test;
import com.smu.model.Case;
import com.smu.model.Requirement;
import com.smu.service.IRequirementService;
import com.smu.service.impl.CaseService;
import com.smu.service.impl.CaseStoreService;
import com.smu.service.impl.RequirementStoreService;
import com.smu.service.impl.StationService;
import com.smu.service.impl.TestService;
import com.smu.util.Require;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class RequirementAction extends ActionSupport{
  
	private IRequirementService requirementService;
    private int c_id;
	private int[] stations;
	private int[] caseId;
	private CaseService caseService;
	private TestService testService;
    private Test t;
    private CaseStoreService caseStoreService;
    private RequirementStoreService requirementStoreService;
    private StationService stationService;
    private int[] stNum;
    private String[] stName;
    private Case c0;
    private Requirement r0;
    private String[] grade;
    private String[] className;

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger(CaseAction.class);

	public String[] getGrade() {
		return grade;
	}

	public void setGrade(String[] grade) {
		this.grade = grade;
	}

	public String[] getClassName() {
		return className;
	}

	public void setClassName(String[] className) {
		this.className = className;
	}

	public Case getC0() {
		return c0;
	}

	public void setC0(Case c0) {
		this.c0 = c0;
	}

	public Requirement getR0() {
		return r0;
	}

	public void setR0(Requirement r0) {
		this.r0 = r0;
	}

	public int[] getStNum() {
		return stNum;
	}

	public void setStNum(int[] stNum) {
		this.stNum = stNum;
	}

	

	public String[] getStName() {
		return stName;
	}

	public void setStName(String[] stName) {
		this.stName = stName;
	}

	public int[] getStations() {
		return stations;
	}

	public void setStations(int[] stations) {
		this.stations = stations;
	}

	public int[] getCaseId() {
		return caseId;
	}

	public void setCaseId(int[] caseId) {
		this.caseId = caseId;
	}

	public StationService getStationService() {
		return stationService;
	}

	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	public CaseStoreService getCaseStoreService() {
		return caseStoreService;
	}

	public void setCaseStoreService(CaseStoreService caseStoreService) {
		this.caseStoreService = caseStoreService;
	}

	public RequirementStoreService getRequirementStoreService() {
		return requirementStoreService;
	}

	public void setRequirementStoreService(
			RequirementStoreService requirementStoreService) {
		this.requirementStoreService = requirementStoreService;
	}

	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public CaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}

	

	

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public IRequirementService getRequirementService() {
		return requirementService;
	}

	public void setRequirementService(IRequirementService requirementService) {
		this.requirementService = requirementService;
	}
	public String browseAllRequirements() throws Exception{
	
		Requirement r = requirementService.getAllRequirements(c_id);
		
		String rcontent = r.getRContent();
		String rscore = r.getRScore();
		String rname = r.getRName();
		String[] contents = rcontent.split("/");
		String[] scores = rscore.split("/");
		String[] names = rname.split("/");
		
		List<Require> r_list = new ArrayList<Require>();
		
		for(int i = 1;i<= scores.length-1;i++){
			Require require = new Require();
			require.setContent(contents[i]);
			require.setScore(scores[i]);
			require.setName(names[i]);
			r_list.add(require);
		}
	
		
		
		
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("RName",names[0]);
		requestMap.put("RContent",contents[0]);
		requestMap.put("RScore",scores[0]);
		requestMap.put("require", r_list);
		return SUCCESS;
	}
	//增加新的考试
    public String addTest() throws Exception{
    	
    	LOGGER.warn(stations[0]);
    	LOGGER.warn(caseId[0]);
    	LOGGER.warn(stName[0]);
    	t.setTestCreateTime(new Timestamp(System.currentTimeMillis()));
    	String gradeClassName = grade[0]+className[0];
    	for(int location = 1;location<=grade.length-1;location++){
    		gradeClassName += ","+ grade[location] + className[location];
		}
        t.setClassName(gradeClassName);
    	int t_id = testService.addTest(t);
    	Test test = new Test();
    	test = testService.getOneTest(t_id);
    	int flag = 0;
    	for(int i=0;i<stNum.length;i++){
    		Station s = new Station();
    		s.setStName(stName[i]);
    		s.setStNumber(stNum[i]);
    		s.setTest(test);
    		int stId = stationService.addStation(s);
    		while(flag<stations.length){
    			if(stations[flag]!=stNum[i]){
    				break;
    			}
    			Case c = new Case();
    	    	CaseStore cs = new CaseStore();
    	    	cs = caseStoreService.getOneCase(caseId[flag]);
    	    	c.setCName(cs.getCName());
    	    	c.setCContent(cs.getCContent());
    	        c.setStation(stationService.getOneStation(stId));
    	        int cId = caseService.addCase(c);
    	        Requirement requirement = new Requirement();
    	        RequirementStore requirementStore = new RequirementStore();
    	        requirementStore = requirementStoreService.getAllRequirements(cs.getCId());
    	        requirement.setCas(caseService.getOneCase(cId));
    	        requirement.setRName(requirementStore.getRName());
    	        requirement.setRContent(requirementStore.getRContent());
    	        requirement.setRScore(requirementStore.getRScore());
    	    	requirementService.addRequirement(requirement);
    	    	flag++;
    		}
    	}
    	
    	return SUCCESS;
    }
    public String updateRequirement() throws Exception{
    	caseService.deleteCase(c_id);
    	caseService.addCase(c0);
    	requirementService.addRequirement(r0);
    	return SUCCESS;
    }
}

