package com.smu.action;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;


import com.smu.model.Case;
import com.smu.model.Requirement;
import com.smu.service.IRequirementService;
import com.smu.service.impl.CaseService;
import com.smu.util.Require;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class RequirementAction extends ActionSupport{
  
	private IRequirementService requirementService;
    private String c_name;
	private Requirement requirement;
	private CaseService caseService;
    private Case c;
    
	public Case getC() {
		return c;
	}

	public void setC(Case c) {
		this.c = c;
	}

	public CaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public IRequirementService getRequirementService() {
		return requirementService;
	}

	public void setRequirementService(IRequirementService requirementService) {
		this.requirementService = requirementService;
	}
	public String browseAllRequirements() throws Exception{
	
		Requirement r = requirementService.getAllRequirements(c_name);
		
		String rcontent = r.getRContent();
		String rscore = r.getRScore();
		String rname = r.getRName();
		String[] contents = rcontent.split(",");
		String[] scores = rscore.split(",");
		String[] names = rname.split(",");
		
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
    public String addRequirement() throws Exception{
    	caseService.addCase(c);
    	requirementService.addRequirement(requirement);
    	return SUCCESS;
    }
    public String updateRequirement() throws Exception{
    	caseService.deleteCase(c_name);
    	caseService.addCase(c);
    	requirementService.addRequirement(requirement);
    	return SUCCESS;
    }
}

