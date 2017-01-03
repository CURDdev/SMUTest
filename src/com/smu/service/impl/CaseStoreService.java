package com.smu.service.impl;

import java.util.List;

import com.smu.dao.ICaseStoreDAO;
import com.smu.model.CaseStore;
import com.smu.service.ICaseStoreService;

public class CaseStoreService implements ICaseStoreService {
private ICaseStoreDAO caseStoreDAO;

public ICaseStoreDAO getCaseDAO() {
	return caseStoreDAO;
}

public void setCaseStoreDAO(ICaseStoreDAO caseDAO) {
	this.caseStoreDAO = caseDAO;
}
public List getCases(){
	return caseStoreDAO.getCases();
}
public CaseStore getOneCase(int c_id){
	return caseStoreDAO.getOneCase(c_id);
}
public boolean deleteCase(int c_id){
	return caseStoreDAO.deleteCase(c_id);
}
public boolean addCase(CaseStore c){
	return caseStoreDAO.addCase(c);
};
}
