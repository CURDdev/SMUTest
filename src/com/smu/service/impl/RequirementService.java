package com.smu.service.impl;
import java.util.*;

import org.hibernate.*;

import com.smu.dao.IRequirementDAO;
import com.smu.dao.IStationDAO;
import com.smu.model.Requirement;
import com.smu.service.IRequirementService;

public class RequirementService implements IRequirementService{
private IRequirementDAO requirementDAO;

public IRequirementDAO getRequirementDAO() {
	return requirementDAO;
}

public void setRequirementDAO(IRequirementDAO requirementDAO) {
	this.requirementDAO = requirementDAO;
}
@Override
public Requirement getAllRequirements(int c_id){
	return requirementDAO.getAllRequirements(c_id);	
}
public boolean addRequirement(Requirement r){
	return requirementDAO.addRequirement(r);
};
public boolean updateRequirement(Requirement r){
	return requirementDAO.updateRequirement(r);
};
public boolean deleteRequirement(int c_id){
	return requirementDAO.deleteRequirement(c_id);
};
}
