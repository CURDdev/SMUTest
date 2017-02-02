package com.smu.service.impl;
import java.util.*;

import org.hibernate.*;

import com.smu.dao.IRequirementStoreDAO;

import com.smu.model.RequirementStore;
import com.smu.service.IRequirementStoreService;

public class RequirementStoreService implements IRequirementStoreService{
private IRequirementStoreDAO requirementStoreDAO;

public IRequirementStoreDAO getRequirementDAO() {
	return requirementStoreDAO;
}

public void setRequirementStoreDAO(IRequirementStoreDAO requirementStoreDAO) {
	this.requirementStoreDAO = requirementStoreDAO;
}
@Override
public RequirementStore getAllRequirements(int c_id){
	return requirementStoreDAO.getAllRequirements(c_id);	
}
public boolean addRequirement(RequirementStore r){
	return requirementStoreDAO.addRequirement(r);
};
public boolean updateRequirement(RequirementStore r){
	return requirementStoreDAO.updateRequirement(r);
};
public boolean deleteRequirement(int c_id){
	return requirementStoreDAO.deleteRequirement(c_id);
};
	public RequirementStore getOneRequirementStore(int r_id){
		return requirementStoreDAO.getOneRequirementStore(r_id);
	};
	public boolean updateStoreErrors(int r_id,String errors){
		return requirementStoreDAO.updateStoreErrors(r_id,errors);
	}
}
