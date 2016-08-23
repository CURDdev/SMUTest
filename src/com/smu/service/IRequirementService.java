package com.smu.service;

import com.smu.model.Requirement;

public interface IRequirementService {
public Requirement getAllRequirements(String c_name);
public boolean addRequirement(Requirement r);
public boolean updateRequirement(Requirement r);
public boolean deleteRequirement(String c_name);
}
