package com.smu.service.impl;

import java.util.List;

import com.smu.dao.ICaseDAO;
import com.smu.model.Case;
import com.smu.service.ICaseService;

public class CaseService implements ICaseService {
private ICaseDAO caseDAO;

public ICaseDAO getCaseDAO() {
	return caseDAO;
}

public void setCaseDAO(ICaseDAO caseDAO) {
	this.caseDAO = caseDAO;
}
public List getCases(int st_id){
	return caseDAO.getCases(st_id);
}
public Case getOneCase(int c_id){
	return caseDAO.getOneCase(c_id);
}
public boolean deleteCase(int c_id){
	return caseDAO.deleteCase(c_id);
}
public int addCase(Case c){
	return caseDAO.addCase(c);
};
}
