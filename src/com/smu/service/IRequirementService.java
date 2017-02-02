package com.smu.service;

import com.smu.model.Requirement;

public interface IRequirementService {
public Requirement getAllRequirements(int c_id);
public boolean addRequirement(Requirement r);
public boolean updateRequirement(Requirement r);
public boolean deleteRequirement(int c_id);
    public boolean updateErrors(int r_id,String errors);
}
